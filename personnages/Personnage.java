package personnages;

import equipement.defense.EquipementDefensif;
import equipement.offense.EquipementOffensif;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.math.*;

public abstract class Personnage {
    private String name;
    private String classe;
    private int maxHp;
    private int niveauDeVie;
    private int forceDAttaque;
    private EquipementOffensif arme;
    private EquipementDefensif bouclier;

    public Personnage(String name, String classe, int niveauDeVie, int forceDAttaque) {
        this.name = name;
        this.classe = classe;
        this.maxHp = niveauDeVie;
        this.niveauDeVie = niveauDeVie;
        this.forceDAttaque = forceDAttaque;
    }

    public String getName() {
        return this.name;
    }

    public String getClasse() {
        return this.classe;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getNiveauDeVie() {
        return this.niveauDeVie;
    }

    public int getAttack() {
        return this.forceDAttaque;
    }

    public EquipementDefensif getBouclier() {
        return this.bouclier;
    }

    public EquipementOffensif getArme() {
        return this.arme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClass(String classe) {
        this.classe = classe;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setNiveauDeVie(int lifePoints) {
        this.niveauDeVie = lifePoints;
    }

    public void setForceDAttaque(int atk) {
        this.forceDAttaque = atk;
    }

    public void equipWeapon(EquipementOffensif weapon) {
        this.arme = weapon;
        this.forceDAttaque += weapon.getAttack();
    }

    public void equipDefensive(EquipementDefensif defensive) {
        this.bouclier = defensive;
        this.maxHp += defensive.getDefense();
        this.niveauDeVie += defensive.getDefense();
    }

    public String getTypeFromDB(String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + table, "root", "password");
            System.out.println("Database connected");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from " + table);
            rs.first();
            return rs.getString(2);
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }
        return "";
    }

    @Override
    public String toString() {
        String message = "\n \u001B[33m*** Caracteristiques ***\u001B[0m \nNom: " + this.name
                + "\nClasse: "
                + this.classe
                + "\nPdv: "
                + (this.niveauDeVie - this.bouclier.getDefense()) + "\u001B[34m (+" + this.bouclier.getDefense()
                + ") \u001B[0m"
                + "\nAtk: " + (this.forceDAttaque - this.arme.getAttack()) + "\u001B[34m (+" + this.arme.getAttack()
                + ") \u001B[37m \n\n\u001B[33mTotal:\u001B[0m \n🛡️  " + this.niveauDeVie
                + "\n🗡️  "
                + this.forceDAttaque
                + " \n\n \u001B[33m*** Equipement ***\u001B[0m \n"
                + this.bouclier.getType() + ": " + this.bouclier.getName() + " +" + this.bouclier.getDefense() + "🛡️\n"
                + this.arme.getType() + ": " + this.arme.getName() + " +" + this.arme.getAttack() + "🗡️";
        return message;
    }
}