package com.swordgroup.algolia;

import java.io.File;
import java.io.IOException;

import com.norconex.collector.http.HttpCollector;
import com.norconex.collector.http.crawler.HttpCrawlerConfig;
import org.junit.Test;

import com.norconex.collector.core.CollectorConfigLoader;
import com.norconex.collector.http.HttpCollectorConfig;
import com.norconex.collector.http.client.impl.GenericHttpClientFactory;
import com.norconex.commons.lang.config.XMLConfigurationUtil;
import com.norconex.commons.lang.encrypt.EncryptionKey;

public class HttpCrawlerConfigTest {


    @Test
    public void testWriteRead() throws IOException {
        //File configFile = new File("minimum-config.xml");
        File configFile = new File("inaxa-configB.xml");

        //"src/site/resources/examples/complex/complex-config.xml");
        HttpCollectorConfig collectorConfig = (HttpCollectorConfig)
                new CollectorConfigLoader(HttpCollectorConfig.class)
                        .loadCollectorConfig(configFile);
        HttpCrawlerConfig crawlerConfig =
                (HttpCrawlerConfig) collectorConfig.getCrawlerConfigs()[0];
        GenericHttpClientFactory clientFactory =
                (GenericHttpClientFactory) crawlerConfig.getHttpClientFactory();
        /*  clientFactory.setRequestHeader("header1", "value1");
        clientFactory.setRequestHeader("header2", "value2");
        clientFactory.setProxyPasswordKey(new EncryptionKey(                "C:\\keys\\myEncryptionKey.txt", EncryptionKey.Source.FILE));
        clientFactory.setAuthPasswordKey(new EncryptionKey("my key"));

        crawlerConfig.setStartURLsProviders(new MockStartURLsProvider());  */


        System.out.println("Writing/Reading this: " + collectorConfig);

        HttpCollector collector = new HttpCollector(collectorConfig);
        collector.start(true);
        //        XMLConfigurationUtil.assertWriteRead(config);
    }
}
