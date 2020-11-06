package fr.rouen.mastergil.tptest;

import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class BankAccountWithDAOUnitTest {
    @Mock
    Connection connectionMock;

    @Mock
    JdbcDAO jdbcDAOMock;

    @InjectMocks
    BankAccountWithDAO bankAccountWithDAO;

    @Before
    public void setUp() throws SQLException {
        //GIVEN
        MockitoAnnotations.initMocks(this);
        Mockito.when(connectionMock.isClosed()).thenReturn(false);
        Mockito.when(connectionMock.isReadOnly()).thenReturn(false);
        Mockito.when(jdbcDAOMock.setUpConnection()).thenReturn(connectionMock);
        Mockito.when(jdbcDAOMock.getSolde()).thenReturn(new Money());
    }

    @Test
    public void shouldCreateAnAccountWhenCreerCompteIsCalledWithoutParamsAndProperlyConfiguredConnection() throws SQLException, ConnectException {
        //GIVEN
        //WHEN
        bankAccountWithDAO.creerCompte();
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).creerCompte();
    }

    @Test(expected = SQLException.class)
    public void shouldThrowSQLExceptionWhenSetupConnectionIsCalledAndConnectionSetAutoCommitFails() throws SQLException, ConnectException {
        //GIVEN
        Mockito.doThrow(SQLException.class).when(connectionMock).setAutoCommit(Mockito.anyBoolean());
        //WHEN
        bankAccountWithDAO.creerCompte();
        //THEN
        //throws an exception
        fail("Should throw an SQLException");
    }

    @Test(expected = ConnectException.class)
    public void shouldThrowConnectExceptionWhenSetupConnectionIsCalledWithConnectionIsClosed() throws SQLException, ConnectException {
        //GIVEN
        Mockito.when(connectionMock.isClosed()).thenReturn(true);
        //WHEN
        bankAccountWithDAO.creerCompte();
        //THEN
        //throws an exception
        fail("Should throw a ConnectException");
    }

    @Test(expected = ConnectException.class)
    public void shouldThrowConnectExceptionWhenSetupConnectionIsCalledWithConnectionIsReadOnly() throws SQLException, ConnectException {
        //GIVEN
        Mockito.when(connectionMock.isReadOnly()).thenReturn(true);
        //WHEN
        bankAccountWithDAO.creerCompte();
        //THEN
        //throws an exception
        fail("Should throw a ConnectException");
    }

    @Test
    public void shouldCreateAnAccountWhenCreerCompteIsCalledWithParamsAndProperlyConfiguredConnection() throws SQLException, ConnectException {
        //GIVEN
        int mnt = 28;
        Devise d = Devise.EURO;
        //WHEN
        bankAccountWithDAO.creerCompte(mnt, d);
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).creerCompte(mnt, d);
    }

    @Test
    public void shouldCallGetSoldeFromBankDaoWhenIsSoldePositifIsCalled() throws SQLException, ConnectException {
        //GIVEN
        boolean positive;
        //WHEN
        positive = bankAccountWithDAO.isSoldePositif();
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).getSolde();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        assertThat(positive).isTrue();
    }

    @Test
    public void shouldCallGetSoldeFromBankDaoWhenConsulterSoldeIsCalled() throws SQLException, ConnectException {
        //GIVEN
        String answer;
        int mnt = 0;
        Devise d = Devise.EURO;
        //WHEN
        answer = bankAccountWithDAO.consulterSolde();
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).getSolde();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        assertThat(answer).isEqualTo("Votre solde actuel est de " + mnt + " " + d.toString());
    }

    @Test
    public void shouldUpdateSoldeWhenDeposerArgentIsCalled() throws SQLException, ConnectException {
        //GIVEN
        Money solde;
        int mnt = 10;
        Devise d = Devise.EURO;
        //WHEN
        solde = bankAccountWithDAO.deposerArgent(mnt);
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).getSolde();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        assertThat(solde.getMontant()).isEqualTo(mnt);
        assertThat(solde.getDevise()).isEqualTo(d);
    }

    @Test
    public void shouldUpdateSoldeWhenRetirerArgentIsCalled() throws SQLException, ConnectException {
        //GIVEN
        Money solde;
        int mnt = 10;
        Devise d = Devise.EURO;
        //WHEN
        solde = bankAccountWithDAO.retirerArgent(mnt);
        //THEN
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).setUpConnection();
        Mockito.verify(jdbcDAOMock, Mockito.times(1)).getSolde();
        Mockito.verify(connectionMock, Mockito.times(1)).setAutoCommit(Mockito.anyBoolean());
        assertThat(solde.getMontant()).isEqualTo(-mnt);
        assertThat(solde.getDevise()).isEqualTo(d);
    }

}