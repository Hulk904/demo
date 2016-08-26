package com.demo.base.xml;

/**
 * Created by yangyuan on 16-8-15.
 */
public class Test {
    public static void main(String[] args) {
        Request req = new Request();
        Document doc = new Document();
        doc.setRequest(req);
        JinbBinder reqBinder = new JinbBinder(Document.class);

        System.out.println(reqBinder.toXml(doc, "utf-8"));
    }
}
