package com.demo.base;

/**
 * Created by yangyuan on 16-8-21.
 */
public class FinalTest {
    public static void main(String[] args) {
        HashEntry hashEntry = new HashEntry<String,String>("123",345,null);
        //hashEntry.next = new HashEntry<String,String>("333",11,null);
        HashEntry[] hashEntries = new HashEntry[4];
        hashEntries[0] =  new HashEntry<String,String>("123",345,null);
        hashEntries[1] =  new HashEntry<String,String>("123",345,null);
        hashEntries[2] =  new HashEntry<String,String>("123",345,null);
        hashEntries[1] = new HashEntry<String,String>("123",345,null);
    }

    static class HashEntry<K,V> {
        final K key;
        final int hash;
        final HashEntry<K,V> next;
        HashEntry(K key,int hash,HashEntry<K,V> next){
            this.key = key;
            this.hash = hash;
            this.next = next;
        }
    }
}
