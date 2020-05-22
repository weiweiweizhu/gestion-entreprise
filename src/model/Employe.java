package model;

import java.util.ArrayList;

public class Employe {
	protected String nom;
	protected int matricule;
	protected static int counter;
	private int indiceSalarial = 1;
	protected int niveau; // indique le niveau hirarchique dans l'entreprise
	protected static int baseSalaire = 1800;
	private static ArrayList<Employe> listeEmp = new ArrayList<>(); // liste pour que les employes basics
	private static ArrayList<Employe> listeCom = new ArrayList<>(); // liste pour que les commerciaux
	private static ArrayList<Employe> listeTotal = new ArrayList<>(); // liste pour tout le monde dans l'entreprise
	protected int nbVente;
	protected boolean isCom;

//	public Employe(String nom) {
//		this.nom = nom;
//		this.matricule = ++counter;
//		this.niveau = 1;
//		listeEmp.add(this);
//	}

	public Employe(String nom,  boolean isCom) {
		this.nom = nom;
		this.matricule = ++counter;
		this.niveau =1;
		listeTotal.add(this);
		this.isCom = isCom;
		if (isCom) {
			listeCom.add(this);
		} else {
			listeEmp.add(this);
		}
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public boolean isCom() {
		return isCom;
	}

	public void setCom(boolean isCom) {
		this.isCom = isCom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getMatricule() {
		return matricule;
	}

	public static int getCounter() {
		return counter;
	}

	public static ArrayList<Employe> getListeEmp() {
		return listeEmp;
	}

	public static void getListeEmpPrint() {
		for (Employe employe : listeEmp) {
			if (!Responsable.listeRes.contains(employe)) {
				System.out.println((Employe) employe);
			}
		}
	}

	public static void setListeEmp(ArrayList<Employe> listeEmp) {
		Employe.listeEmp = listeEmp;
	}

	public static ArrayList<Employe> getListeCom() {
		return listeCom;
	}

	public static void getListeComPrint() {
		for (Employe employe : listeCom) {
			System.out.println(employe);
		}
	}

	public static void setListeCom(ArrayList<Employe> listeCom) {
		Employe.listeCom = listeCom;
	}

	public static ArrayList<Employe> getListeTotal() {
		return listeTotal;
	}

	public static void getListeTotalPrint() {
		for (Employe employe : listeTotal) {
			System.out.println(employe);
		}
	}

	public static void setListeTotal(ArrayList<Employe> listeTotal) {
		Employe.listeTotal = listeTotal;
	}
	
	public static void setBaseSalaire(int baseSalaire) {
		Employe.baseSalaire = baseSalaire;
	}

	public int getIndiceSalarial() {
		return indiceSalarial;
	}

	public void setIndiceSalarial(int indiceSalarial) {
		this.indiceSalarial = indiceSalarial;
	}

	public int getNbVente() {
		return nbVente;
	}

	public void setNbVente(int nbVente) {
		this.nbVente = nbVente;
	}

	public int calculSalaire() {
		int salaire = this.indiceSalarial * baseSalaire;

		if (nbVente > 10 && nbVente < 20) {
			salaire += salaire * 1.2;
		}
		if (nbVente >= 20 && nbVente < 50) {
			salaire += salaire * 4 / 3;
		}
		if (nbVente >= 50 && nbVente < 80) {
			salaire += salaire * 5 / 3;
		} else if (nbVente >= 80) {
			salaire += salaire;
		}
		return salaire;
	}

	@Override
	public String toString() {
		if (this.isCom) {
			return "-----------------\nCommercial : " + nom + "\nMatricule : " + matricule + "\nSalaire fixe: "
					+ baseSalaire * indiceSalarial + "\nNombre de vente : " + getNbVente() + "\nSalaire total : "
					+ calculSalaire();
		}
		return "-----------------\nEmploye : " + nom + "\nMatricule : " + matricule + "\nSalaire : "
				+ baseSalaire * indiceSalarial;
	}

	public static int getBaseSalaire() {
		return baseSalaire;
	}
}
