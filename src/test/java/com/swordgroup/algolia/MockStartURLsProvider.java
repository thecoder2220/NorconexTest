package com.swordgroup.algolia;

import java.util.Iterator;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;

import com.norconex.collector.http.crawler.IStartURLsProvider;

public class MockStartURLsProvider implements IStartURLsProvider {

    @Override
    public Iterator<String> provideStartURLs() {
        return new ObjectArrayIterator<>(
                "http://www.provided1.com",
                "http://www.provided2.com",
                "http://www.provided3.com");
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return MockStartURLsProvider.class.equals(obj.getClass());
    }
}
