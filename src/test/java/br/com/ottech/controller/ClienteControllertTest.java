package br.com.ottech.controller;
/*
import br.com.ottech.models.Cliente;
import br.com.ottech.repositories.ClienteRepository;
import br.com.ottech.services.ClienteService;
import com.nitorcreations.junit.runners.NestedRunner;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(NestedRunner.class)
public class ClienteControllertTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @BeforeAll
    void start() {

        clienteRepository.deleteAll();
    }

    @Test
    @Order(1)
    @DisplayName("Cadastrar Um Cliente")
    public void CadastraUmCliente() {

        HttpEntity<Cliente> requisicao = new HttpEntity<Cliente>(new Cliente(0L,
                "Fulano", "12132156623"));

        ResponseEntity<Cliente> resposta = testRestTemplate
                .exchange("/api/clientes/registrar", HttpMethod.POST, requisicao, Cliente.class);

        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
        assertEquals(requisicao.getBody().getNomeCliente(), resposta.getBody().getNomeCliente());
        assertEquals(requisicao.getBody().getNumCnpj(), resposta.getBody().getNumCnpj());
    }

    @Test
    @Order(2)
    @DisplayName("Não deve permitir duplicação do Usuário")
    public void naoDeveDuplicarUsuario() {

        clienteService.cadastrarCliente(new Cliente(0L,
                "Fulano", "12132156623"));

        HttpEntity<Cliente> requisicao = new HttpEntity<Cliente>(new Cliente(0L,
                "Fulano", "12132156623"));

        ResponseEntity<Cliente> resposta = testRestTemplate
                .exchange("/api/clientes/registrar", HttpMethod.POST, requisicao, Cliente.class);

        assertEquals(HttpStatus.BAD_REQUEST, resposta.getStatusCode());
    }

    @Test
    @Order(3)
    @DisplayName("Alterar um Cliente")
    public void atualizarUmCliente() {

        Optional<Cliente> cadastrarCliente = clienteService.cadastrarCliente(new Cliente(0L,
                "Fulano", "12132156623"));

        Cliente atualizarCliente = new Cliente(cadastrarCliente.get().getId(),
                "Ciclano", "12132156623");

        HttpEntity<Cliente> requisicao = new HttpEntity<Cliente>(atualizarCliente);

        ResponseEntity<Cliente> resposta = testRestTemplate
                .exchange("/api/clientes/atualizar", HttpMethod.PUT, requisicao, Cliente.class);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());
        assertEquals(atualizarCliente.getNomeCliente(), resposta.getBody().getNomeCliente());
        assertEquals(atualizarCliente.getNumCnpj(), resposta.getBody().getNumCnpj());
    }

    @Test
    @DisplayName("Apagar Usuário!")
    @Order(4)
    public void deveApagarUmUsuario() {

        Optional<Cliente> buscarCliente = clienteService.cadastrarCliente(new Cliente(0L,
                "Fulano", "12132156623"));

        ResponseEntity<String> resposta = testRestTemplate
                .exchange("/api/clientes/" + buscarCliente.get().getId(), HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());

    }
}*/


