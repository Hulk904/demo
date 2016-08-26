package com.demo.base.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by yangyuan on 16-8-15.
 */
public class JinbBinder {
        //多线程安全的Context.
        private JAXBContext jaxbContext;

        /**
         * @param types 所有需要序列化的Root对象的类型.
         */
        public JinbBinder(Class<?>... types) {
            try {
                jaxbContext = JAXBContext.newInstance(types);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Java Object->Xml.
         */
        public String toXml(Object root) {
            try {
                StringWriter writer = new StringWriter();
                createMarshaller("UTF-8", null, true).marshal(root, writer);
                return writer.toString();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Java Object->Xml.
         */
        public String toXml(Object root, String encoding) {
            try {
                StringWriter writer = new StringWriter();
                createMarshaller(encoding, null, false).marshal(root, writer);
                return writer.toString();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Java Object->Xml.
         */
        public String toXml(Object root, String encoding, String declaration) {
            try {
                StringWriter writer = new StringWriter();
                writer.append(declaration);
                createMarshaller(encoding, declaration, false).marshal(root, writer);
                return writer.toString();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Xml->Java Object.
         */
        @SuppressWarnings("unchecked")
        public <T> T fromXml(String xml) {
            try {
                //返回结果替换掉xmlns否则转对象的时候会报错
                if (xml.indexOf("xmlns=\"http://www.opentravel.org/OTA/2003/05\"") != -1) {
                    xml = xml.replace("xmlns=\"http://www.opentravel.org/OTA/2003/05\"", "");
                }
                StringReader reader = new StringReader(xml);
                return (T) createUnmarshaller().unmarshal(reader);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 创建Marshaller, 设定encoding(可为Null),  设定declaration(可为Null).
         */
        public Marshaller createMarshaller(String encoding, String declaration, Boolean formatted) {
            try {
                Marshaller marshaller = jaxbContext.createMarshaller();

                //是否格式化XML
                if (formatted) {
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                }

                //设置编码方式
                if (null != encoding && !"".equals(encoding)) {
                    marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
                }

                //设置XML声明
                if (null != declaration/* && !"".equals(declaration)*/) {
                    marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
                }
                return marshaller;
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * 创建UnMarshaller.
         */
        public Unmarshaller createUnmarshaller() {
            try {
                return jaxbContext.createUnmarshaller();
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }

}
