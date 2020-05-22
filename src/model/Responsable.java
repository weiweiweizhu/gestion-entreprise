package model;

import java.util.ArrayList;

public class Responsable extends Employe {
	protected static ArrayList<Responsable> listeRes = new ArrayList<>();
	protected static ArrayList<Responsable> listeResCom = new ArrayList<>();
	protected static ArrayList<Responsable> listeResTotal = new ArrayList<>();
	private ArrayList<Employe> listeResSub = new ArrayList<>();
	protected boolean isCom;

	public Responsable(String nom, boolean isCom, int niveauResponsable) {
		super(nom, isCom);
		niveau = niveauResponsable;
		listeResTotal.add(this);
		if (isCom) {
			listeResCom.add(this);
		} else {
			listeRes.add(this);
		}
	}

	
	
	public void addSub(Employe e) {
		listeResSub.add(e);
	}

	public static ArrayList<Responsable> getListeRes() {
		return listeRes;
	}

	public static void setListeRes(ArrayList<Responsable> listeRes) {
		Responsable.listeRes = listeRes;
	}

	public static void getListeResPrint() {
		for (Responsable responsable : listeRes) {
			System.out.println(responsable);
		}
	}

	public static ArrayList<Responsable> getListeResCom() {
		return listeResCom;
	}

	public static void getListeResComPrint() {
		for (Responsable responsable : listeResCom) {
			System.out.println(responsable);
		}
	}

	public static void setListeResCom(ArrayList<Responsable> listeResCom) {
		Responsable.listeResCom = listeResCom;
	}

	public static ArrayList<Responsable> getListeResTotal() {
		return listeResTotal;
	}

	public static void setListeResTotal(ArrayList<Responsable> listeResTotal) {
		Responsable.listeResTotal = listeResTotal;
	}

	public ArrayList<Employe> getListeResSub() {
		return listeResSub;
	}

	public void getListeResSubPrint() {
		for(Employe employe : listeResSub) {
			System.out.println(employe);
		}
	}
	
	
	public void setListeResSub(ArrayList<Employe> listeResSub) {
		this.listeResSub = listeResSub;
	}

	@Override
	public String toString() {
		return super.toString() + "\nNiveau de responsable : " + this.niveau;
	}

}
