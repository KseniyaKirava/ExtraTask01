//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0-b170531.0717 
//         See <a href="https://jaxb.java.net/">https://jaxb.java.net/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.08.07 at 01:52:16 AM MSK 
//


package by.htp.kirova.task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubCategory complex type.
 *
 * <p>The following schema fragment specifies the expected         content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SubCategory"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="news" type="{http://catalogLib.kirova.htp.by}News" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubCategory", propOrder = {
        "news"
})
public class SubCategory implements BaseEntity {

    protected List<News> news;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the news property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the news property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNews().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link News }
     */
    public List<News> getNews() {
        if (news == null) {
            news = new ArrayList<News>();
        }
        return this.news;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        SubCategory that = (SubCategory) o;
        return Objects.equals(news, that.news) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (news == null ? 0 : news.hashCode()) * result;
        result = result * 31 + (name == null ? 0 : name.hashCode()) * result;
        return result;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "news=" + news +
                ", name='" + name + '\'' +
                '}';
    }
}
