package test;

import modele.Personne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Test
    void testCreationValide() {
        Personne p = new Personne("Dupont", "Alice");
        assertEquals("Dupont", p.getNom());
        assertEquals("Alice", p.getPrenom());
    }

    @Test
    void testNomInvalide_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne(null, "Alice");
        });
        assertEquals("Erreur dans le nom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testNomInvalide_TropCourt() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne("Du", "Alice");
        });
        assertEquals("Erreur dans le nom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testNomInvalide_CaracteresInvalides() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne("Dup0nt", "Alice");
        });
        assertEquals("Erreur dans le nom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testPrenomInvalide_Null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne("Dupont", null);
        });
        assertEquals("Erreur dans le prenom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testPrenomInvalide_TropCourt() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne("Dupont", "Al");
        });
        assertEquals("Erreur dans le prenom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testPrenomInvalide_CaracteresInvalides() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Personne("Dupont", "Al!ce");
        });
        assertEquals("Erreur dans le prenom ! Merci de corriger", exception.getMessage());
    }

    @Test
    void testToString() {
        Personne p = new Personne("Durand", "Lucie");
        String attendu = "Nom : Durand\nPrénom : Lucie";
        assertEquals(attendu, p.toString());
    }
}