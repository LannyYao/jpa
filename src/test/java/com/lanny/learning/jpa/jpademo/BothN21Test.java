package com.lanny.learning.jpa.jpademo;

import com.lanny.learning.jpa.entity.bothn21.JpaAspect;
import com.lanny.learning.jpa.entity.bothn21.JpaAsset;
import com.lanny.learning.jpa.repository.AspectRepository;
import com.lanny.learning.jpa.repository.AssetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:18 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BothN21Test {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private AspectRepository aspectRepository;

    @Test
    public void init() {
        // init table
    }

    /**
     * 双向多对一关系应该先保存1的一端后保存n的一端
     */
    @Test
    public void testBothManyToOnePersist() {
        JpaAsset asset = new JpaAsset();
        asset.setName("asset-test");

        JpaAspect aspect1 = new JpaAspect();
        aspect1.setName("aspect-test-1");
        JpaAspect aspect2 = new JpaAspect();
        aspect2.setName("aspect-test-2");

        //建立关联关系
        asset.getAspects().add(aspect1);
        asset.getAspects().add(aspect2);

        aspect1.setAsset(asset);
        aspect2.setAsset(asset);

        //persist
        assetRepository.save(asset);

        aspectRepository.save(aspect1);
        aspectRepository.save(aspect2);
    }
}
