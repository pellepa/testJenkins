package fr.rouen.mastergil.tptest;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountUnitTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() throws Exception {
        bankAccount = new BankAccount();
    }

    @Test
    public void consulterSolde_doit_afficher_solde_actuel() throws Exception {
        //Given
        int montant = new Random().nextInt(999);
        Devise devise = Devise.values()[new Random().nextInt(Devise.values().length)];
        bankAccount.creerCompte(montant, devise);
        //When
        final String solde = bankAccount.consulterSolde();
        //Then
        assertThat(solde).isEqualTo("Votre solde actuel est de " + montant + " " + devise.name());
    }

    @Test
    public void deposerArgent_doit_ajouter_montant_au_solde_actuel() throws Exception {
        //Given
        final int soldeInitial = 20;
        final int depot = 10;
        bankAccount.creerCompte(soldeInitial, Devise.DOLLAR);
        //When
        bankAccount.deposerArgent(depot);
        //Then
        assertThat(bankAccount.solde.getDevise()).isEqualTo(Devise.DOLLAR);
        assertThat(bankAccount.solde.getMontant()).isEqualTo(soldeInitial + depot);
    }

    @Test
    public void retirerArgent_doit_soustraire_montant_au_solde_actuel() throws Exception {
        //Given
        final int soldeInitial = 20;
        final int retrait = 10;
        bankAccount.creerCompte(soldeInitial, Devise.DOLLAR);
        //When
        bankAccount.retirerArgent(retrait);
        //Then
        assertThat(bankAccount.solde.getDevise()).isEqualTo(Devise.DOLLAR);
        assertThat(bankAccount.solde.getMontant()).isEqualTo(soldeInitial - retrait);
    }

    @Test
    public void creerCompte_sans_valeur_doit_avoir_solde_non_null_et_a_zero_euro() throws Exception {
        //Given
        //When
        bankAccount.creerCompte();
        //Then
        assertThat(bankAccount.solde).isNotNull();
        assertThat(bankAccount.solde.getDevise()).isEqualTo(Devise.EURO);
        assertThat(bankAccount.solde.getMontant()).isEqualTo(0);
    }

    @Test
    public void creerCompte_avec_valeur_doit_avoir_solde_avec_valeurs() throws Exception {
        //Given
        //When
        bankAccount.creerCompte(20, Devise.DOLLAR);
        //Then
        assertThat(bankAccount.solde.getDevise()).isEqualTo(Devise.DOLLAR);
        assertThat(bankAccount.solde.getMontant()).isEqualTo(20);
    }

    @Test
    public void isSoldePositif_doit_retourner_vrai_si_solde_superieur_a_zero() throws Exception {
        //Given
        bankAccount.creerCompte(20, Devise.DOLLAR);
        //When
        final boolean soldePositif = bankAccount.isSoldePositif();
        //Then
        assertThat(soldePositif).isTrue();
    }

    @Test
    public void isSoldePositif_doit_retourner_vrai_si_solde_egale_a_zero() throws Exception {
        //Given
        bankAccount.creerCompte(0, Devise.DOLLAR);
        //When
        final boolean soldePositif = bankAccount.isSoldePositif();
        //Then
        assertThat(soldePositif).isTrue();
    }

    @Test
    public void isSoldePositif_doit_retourner_faux_si_solde_inferieur_a_zero() throws Exception {
        //Given
        bankAccount.creerCompte(-20, Devise.DOLLAR);
        //When
        final boolean soldePositif = bankAccount.isSoldePositif();
        //Then
        assertThat(soldePositif).isFalse();
    }

}