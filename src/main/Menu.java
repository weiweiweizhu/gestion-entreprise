package main;

import java.util.Scanner;

import model.Employe;
import model.Responsable;

public class Menu {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int choix;
		boolean continuer = true;

		while (continuer) {
			boolean bool = true;
			Tools.init();
			choix = in.nextInt();

			switch (choix) {

			case 0:
				Tools.bye();
				continuer = false;
				break;

			case 1:
				while (bool) {
					Tools.menu1();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Tools.creerEmp();
						break;
					case 2:
						Tools.creerRes();
						break;
					case 3:
						Tools.creerCom();
						break;
					default:
						Tools.err();
						break;
					}
				}
				break;

			case 2:
				while (bool) {
					Tools.menu2();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Employe.getListeEmpPrint();
						break;
					case 2:
						Employe.getListeComPrint();
						break;
					case 3:
						Responsable.getListeResComPrint();
						Responsable.getListeResPrint();
						break;
					case 4:
						Employe.getListeTotalPrint();
						break;
					default:
						Tools.err();
						break;
					}
				}
				break;

			case 3:
				while (bool) {
					Tools.menu3();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Tools.afficherSalaireId();
						break;
					case 2:
						Tools.afficherSalaire();
						break;
					default:
						Tools.err();
						break;
					}
				}
				break;

			case 4:
				while (bool) {
					Tools.menu4();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Tools.ajouterEmpARes();
						break;
					case 2:
						Tools.supprimerEmp();
						break;
					default:
						Tools.err();
						break;
					}
				}
				break;

			case 5:
				Tools.afficherEquipe();
				break;

			case 6:
				while (bool) {
					Tools.menu6();
					int choix2 = in.nextInt();

					switch (choix2) {
					case 0:
						bool = false;
						break;
					case 1:
						Tools.modifierIndiceSal();
						break;
					case 2:
						Tools.modifierBaseSal();
						break;
					case 3:
						Tools.modifierNbVente();
						break;

					default:
						Tools.err();
						break;
					}
				}
				break;

			case 7:
				Tools.supprimer();
				break;

			default:
				Tools.err();
				break;
			}

		}

	}

}
