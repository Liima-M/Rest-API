package com.matheus.beicinhofoodapi;

import com.matheus.beicinhofoodapi.domain.exception.NegocioException;
import com.matheus.beicinhofoodapi.domain.exception.UsuarioNaoEncontradoException;
import com.matheus.beicinhofoodapi.domain.model.Usuario;
import com.matheus.beicinhofoodapi.domain.repository.UsuarioRepository;
import com.matheus.beicinhofoodapi.domain.service.CadastroUsuarioService;
import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

//import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastroUsuarioTest {

    @InjectMocks
    private CadastroUsuarioService cadastroUsuario;

    @Mock
    private UsuarioRepository usuarioRepository;

    private Usuario usuario;

    @BeforeEach
    public void setUp(){


    }

    @Test
    public void testarCadastroUsuarioComSucesso(){
        usuario = new Usuario();
        usuario.setId(6L);
        usuario.setNome("Lucas");
        usuario.setEmail("lucas@gmail.com");
        usuario.setSenha("1234");
        usuario.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        when(usuarioRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        //when(usuarioRepository.detach(any(Usuario.class))).thenReturn(usuario);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        usuario = cadastroUsuario.salvar(usuario);

        assertThat(usuario).isNotNull();



    }
    @Test
    public void erroAoCadastroUsuarioSemNome(){
        usuario = new Usuario();
        usuario.setId(6L);
        usuario.setNome("");
        usuario.setEmail("matheusportinho12@gmail.com");
        usuario.setSenha("123");
        usuario.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        when(usuarioRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        //when(usuarioRepository.detach(any(Usuario.class))).thenReturn(usuario);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        usuario = cadastroUsuario.salvar(usuario);

        assertThat(usuario).isNull();



    }

    @Test
    public void erroAoCadastrarUsarioComEmailRepetido(){
        usuario = new Usuario();
        usuario.setId(7L);
        usuario.setNome("lucas");
        usuario.setEmail("matheusportinho12@gmail.com");
        usuario.setSenha("1234");
        usuario.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        Usuario usuarioSalvo = new Usuario();
        usuarioSalvo.setId(6L);
        usuarioSalvo.setNome("lucas");
        usuarioSalvo.setEmail("matheus.lima@gmail.com");
        usuarioSalvo.setSenha("1234");
        usuarioSalvo.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        when(usuarioRepository.findByEmail(anyString())).thenReturn(Optional.of(usuarioSalvo));

        NegocioException e = assertThrows(NegocioException.class, () ->cadastroUsuario.salvar(usuario));

        assertThat(e).isNotNull();

    }

    @Test
    public void erroAoCadastroUsuarioSemUmOuMaisCampos(){
        usuario = new Usuario();
        usuario.setId(6L);
        usuario.setNome("");
        usuario.setEmail("");
        usuario.setSenha("1234");
        usuario.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        when(usuarioRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        usuario = cadastroUsuario.salvar(usuario);

        assertThat(usuario).isNull();



    }

    @Test
    public void devefalharAoAtualizarSenhaSemCorrespondencia(){
        usuario = new Usuario();
        usuario.setId(6L);
        usuario.setNome("Matheus");
        usuario.setEmail("matheus.lima@gmail.com");
        usuario.setSenha("1234");
        usuario.setDataCadastro(OffsetDateTime.now(ZoneOffset.of("-03:00")));

        when(usuarioRepository.findById(anyLong())).thenReturn(Optional.of(usuario));

        NegocioException e = assertThrows(NegocioException.class, () ->{cadastroUsuario.alterarSenha(6L,"Senha atual informada não coincide com a senha do usuário.", "Nova senha");});

        assertThat(e).isNotNull();
    }

    @Test
    public void deveFalharAoBuscarUsuarioInexistente(){
        when(usuarioRepository.findById(8L)).thenReturn(Optional.empty());

        UsuarioNaoEncontradoException e = assertThrows(UsuarioNaoEncontradoException.class, () -> cadastroUsuario.buscarOuFalhar(8L));

        assertThat(e).isNotNull();
    }


}
