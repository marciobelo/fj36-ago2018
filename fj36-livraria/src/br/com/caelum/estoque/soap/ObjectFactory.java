
package br.com.caelum.estoque.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.estoque.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetQuantidades_QNAME = new QName("http://caelum.com.br/estoquews/v1", "getQuantidades");
    private final static QName _TokenUsuario_QNAME = new QName("http://caelum.com.br/estoquews/v1", "tokenUsuario");
    private final static QName _GetQuantidadesResponse_QNAME = new QName("http://caelum.com.br/estoquews/v1", "getQuantidadesResponse");
    private final static QName _GetQuantidade_QNAME = new QName("http://caelum.com.br/estoquews/v1", "getQuantidade");
    private final static QName _GetQuantidadeResponse_QNAME = new QName("http://caelum.com.br/estoquews/v1", "getQuantidadeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.estoque.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetQuantidade }
     * 
     */
    public GetQuantidade createGetQuantidade() {
        return new GetQuantidade();
    }

    /**
     * Create an instance of {@link GetQuantidadeResponse }
     * 
     */
    public GetQuantidadeResponse createGetQuantidadeResponse() {
        return new GetQuantidadeResponse();
    }

    /**
     * Create an instance of {@link GetQuantidadesResponse }
     * 
     */
    public GetQuantidadesResponse createGetQuantidadesResponse() {
        return new GetQuantidadesResponse();
    }

    /**
     * Create an instance of {@link GetQuantidades }
     * 
     */
    public GetQuantidades createGetQuantidades() {
        return new GetQuantidades();
    }

    /**
     * Create an instance of {@link ItemEstoque }
     * 
     */
    public ItemEstoque createItemEstoque() {
        return new ItemEstoque();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuantidades }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "getQuantidades")
    public JAXBElement<GetQuantidades> createGetQuantidades(GetQuantidades value) {
        return new JAXBElement<GetQuantidades>(_GetQuantidades_QNAME, GetQuantidades.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "tokenUsuario")
    public JAXBElement<String> createTokenUsuario(String value) {
        return new JAXBElement<String>(_TokenUsuario_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuantidadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "getQuantidadesResponse")
    public JAXBElement<GetQuantidadesResponse> createGetQuantidadesResponse(GetQuantidadesResponse value) {
        return new JAXBElement<GetQuantidadesResponse>(_GetQuantidadesResponse_QNAME, GetQuantidadesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuantidade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "getQuantidade")
    public JAXBElement<GetQuantidade> createGetQuantidade(GetQuantidade value) {
        return new JAXBElement<GetQuantidade>(_GetQuantidade_QNAME, GetQuantidade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetQuantidadeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://caelum.com.br/estoquews/v1", name = "getQuantidadeResponse")
    public JAXBElement<GetQuantidadeResponse> createGetQuantidadeResponse(GetQuantidadeResponse value) {
        return new JAXBElement<GetQuantidadeResponse>(_GetQuantidadeResponse_QNAME, GetQuantidadeResponse.class, null, value);
    }

}
