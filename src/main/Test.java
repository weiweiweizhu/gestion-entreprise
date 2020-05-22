package main;

import model.Employe;
import model.Responsable;

public class Test {
	public static void main(String[] args) {
		Employe e1 = new Employe("E1", false);
		Employe e2 = new Employe("E2", true);
		e2.setIndiceSalarial(2);

		Responsable r1 = new Responsable("R1", false, 2);
		System.out.println(r1);
//		Employe.getListeEmployeOnly();
//		Employe.getListeEmployeAll();
//		Responsable.getListeRes();

		if (r1 instanceof Employe) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}

//		Tools.afficherSalaire();
//		Tools.creer();
	}
}
