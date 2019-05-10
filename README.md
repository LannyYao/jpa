
# JPA demo

<!-- TOC -->

- [JPA demo](#jpa-demo)
    - [Embed](#embed)
    - [@NameQuery](#namequery)
    - [@GeneratedValue(strategy)](#generatedvaluestrategy)
        - [javax.persistence.GenerationType 中定义了以下几种可供选择的策略：](#javaxpersistencegenerationtype-中定义了以下几种可供选择的策略)
        - [@GenericGenerator自定义生成策略（hibernate默认支持13种生成策略）](#genericgenerator自定义生成策略hibernate默认支持13种生成策略)
    - [@Entity](#entity)
    - [@Table](#table)
    - [@Temporal](#temporal)
    - [@Inheritance](#inheritance)
    - [@NamesEntityGraph](#namesentitygraph)
    - [Fetch.LAZY no session exception](#fetchlazy-no-session-exception)
        - [@Transactional](#transactional)
    - [ddl-auto](#ddl-auto)
    - [CascadeType](#cascadetype)
    - [orphanRemoval](#orphanremoval)
    - [mappedBy](#mappedby)

<!-- /TOC -->

## Embed

| @Embeddable | @Embedded | @EmbeddedId |
| :--------:    | :-----:    | :----: |
| 注释Java类，表示类是嵌入类 | 注释属性，表示该属性的类是嵌入类 | 注释联合主键 |

---

## @NameQuery
  
自定义查询注解，于Entity类中声明，于repo中加入相应方法，若同时存在query语句，以NameQuery为主

---

## @GeneratedValue(strategy)  

### javax.persistence.GenerationType 中定义了以下几种可供选择的策略：

| AUTO | IDENTITY | SEQUENCE | TABLE |
| :--------:    | :-----:    | :----: | :----: |
| JPA自动选择合适的策略，是默认选项 | 采用数据库 ID自增长的方式来自增主键字段，Oracle不支持这种方式 | 通过序列产生主键，通过 @SequenceGenerator 注解指定序列名，MySql不支持这种方式 | 通过表产生主键，框架借由表模拟序列产生主键，使用该策略可以使应用更易于数据库移植 |

---

### @GenericGenerator自定义生成策略（hibernate默认支持13种生成策略）

 ```java
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "")
 ```

- native
- uuid
- hilo
- assigned
- identity
- select
- sequence
- seqhilo
- increment
- foreign
- guid
- uuid.hex
- sequence-identity

---

## @Entity  

标注用于实体类声明语句之前，指出该Java 类为实体类，将映射到指定的数据库表,如声明一个实体类 Customer，它将映射到数据库中的 customer 表上 (only way ?)

---

## @Table  

当实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，该标注与 @Entity 标注并列使用，置于实体类声明语句之前，可写于单独语句行，也可与声明语句同行。@Table 标注的常用选项是 name，用于指明数据库的表名 @Table标注还有一个两个选项 catalog 和 schema 用于设置表所属的数据库目录或模式，通常为数据库名。uniqueConstraints 选项用于设置约束条件，通常不须设置

---

## @Temporal  

在核心的 Java API 中并没有定义 Date 类型的精度(temporal precision).而在数据库中,表示 Date类型的数据有 DATE, TIME, 和 TIMESTAMP 三种精度(即单纯的日期,时间,或者两者兼备). 在进行属性映射时可使用@Temporal注解来调整精度.

---

## @Inheritance

| Single_Table策略 | Joined策略 | Table_Per_Class策略 |
| :--------:  | :-----:    | :----: |
| 父类实体和子类实体共用一张数据库表，在表中通过一列辨别字段来区别不同类别的实体 | 父类实体和子类实体分别对应数据库中不同的表，子类实体的表中只存在其扩展的特殊属性，父类的公共属性保存在父类实体映射表中 | 父类实体和子类实体每个类分别对应一张数据库中的表，子类表中保存所有属性，包括从父类实体中继承的属性。|

---

## @NamesEntityGraph

1. 实体图通过独立于查询的方法指定应该从数据库中获取的实体的图。这意味着，你需要为实体图创建一个独立的定义，并在需要时与查询合并。下段代码展示了如何定义根据作者名提取书名@NamedEntityGraph。

    ```java
    @Entity
    @NamedEntityGraph(name = "graph.AuthorBooks", attributeNodes = @NamedAttributeNode("books"))
    public class Author implements Serializable {
    …
    }
    ```

    现在，实体管理器可以用这个图为参考，通过一次查询获取所有作者和书名。在图的定义中可以看到，笔者只提供了包含相关实体的属性名称。因此，笔者将@NamedEntityGraph作为loadgraph (负载图)，这样便可提取其他所有属性及其定义的获取类型，如下所示：

    ```java
    public interface AuthorRepository extends JpaRepository<Author, Long> {

        //通过@EntityGraph来指定Account类中定义的NamedEntityGraph
        @Query("SELECT DISTINCT a FROM Author a")
        @EntityGraph(value = "graph.AuthorBooks", type = EntityGraphType.FETCH)
        List<Author> findAll();
    }
    ```

    该示例展示了一个非常简单的实体图，在实际的应用中，很可能会用到更复杂的图，但这也不成问题。你可以定义多个 @NamedAttributeNodes 以定义更复杂的图，也可以用@NamedSubGraph 注解来创建多层次的图。
2. 通过@EntityGraph及其子类型@NamedEntityGraph来定义获取和负载.它们可以被直接在实体类上,用来配置查询结果的获取计划.获取的方式(获取/负载)可以通过@EntityGraph的type属性来进行配置. 在一个实体类上定义 named entity graph

    ```java
    @Entity
    @NamedEntityGraph(name = "GroupInfo.detail",
    attributeNodes = @NamedAttributeNode("members"))
    public class GroupInfo {

    // default fetch mode is lazy.
    @ManyToMany
    List<GroupMember> members = new ArrayList<GroupMember>();

    …
    }
    ```

    在repository接口中引用在实体类上定义的named entity graph

    ```java
    @Repository
    public interface GroupRepository extends CrudRepository<GroupInfo, String> {

    @EntityGraph(value = "GroupInfo.detail", type = EntityGraphType.LOAD)
    GroupInfo getByGroupName(String name);
    }
    ```

    它也可以通过@EntityGraph注解来直接点对点的指定entity graphs.假如依照EntityGraph attributePaths可以被正确的找到,就可以不用在实体类上写@NamedEntityGraph注解了:

    ```java
    @Repository
    public interface GroupRepository extends CrudRepository<GroupInfo, String> {

    @EntityGraph(attributePaths = { "members" })
    GroupInfo getByGroupName(String name);

    }
    ```

---

## Fetch.LAZY no session exception  

出现该错误的原因是Hibernate使用sessionFactory来管理session，我们每进行一次数据库操作时都会新建一个session对象，当我们操作完成后，hibernate就会在dao层立即关闭该session。所以当我们操作类中另一个类的具体属性时，因session已经关闭，就会报错。这是Hibernate的懒加载策略，因为每一次查询我们并不会使用到查询对象关联的所有对象，所有Hibernate在查询数据库时并不会把类关联的对象统一查出来。
  
### @Transactional

- 进行事务包裹，同时也会绑定session,用事务包裹之后，会当做一个整体，没有提交时session不会交给SessionFactory管理,也就不会被关掉

---
  
## ddl-auto  

1. create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
2. create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
3. update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
4. validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值

---

## CascadeType

1. PERSIST: 当父实体Person被持久化时，会连同持久化子实体Phone。对象会进入到持久化状态，对该对象的操作会自动同步到数据库。
2. MERGE: 在合并期间，获取子实体Phone时，会连同获取级联的父实体Person。这个级联只能合并数据库已存在的实体。对象会进入到被管理状态，对该对象（可以是任何状态的对象）的操作会自动同步到数据库。A类新增或者变化，会级联B对象（新增或者变化）
3. REMOVE: 沿父实体一个删除级联的子实体
4. DETACH: 分离所有相关联的实体，该实体已在数据库中，对象将处于分离状态，对该对象的操作不会同步到数据库。
5. REFRESH: 当对父实体Person级联的对象进行操作并保存时，会关联保存子实体Phone到数据库。A类新增或者变化，会级联B对象（新增或者变化）

---

## orphanRemoval

- true: remove操作会删除目标对象
- false: remove操作会删除目标对象与当前对象的关系，将目标对象对当前对象的引用设置的null，不会直接删除目标对象

---

## mappedBy

1. 数据库中1对多的关系，关联关系总是被多方维护的即外键建在多方，我们在单方对象的@OneToMany（mappedby=” “）把关系的维护交给多方对象的属性去维护关系
2. 单向关系不需要设置该属性，双向关系必须设置，避免双方都建立外键字段
    - 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性
    - mappedBy标签一定是定义在the owned side（被拥有方的），他指向theowning side（拥有方）；
    - 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
    - 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
