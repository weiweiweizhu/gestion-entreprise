package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import model.Employe;
import model.Responsable;

public class Tools {
	private static ArrayList<Employe> listeResTotal = new ArrayList<>();

	public static void init() {
		System.out.println("0 - Quiter le program");
		System.out.println("1 - Creer un employe");
		System.out.println("2 - Afficher la liste des employes / commerciaux / responsables");
		System.out.println("3 - Afficher le salaire d'un employé / de tous les employes");
		System.out.println("4 - Ajouter / supprimer un employe d'une équipe d'un responsable");
		System.out.println("5 - Afficher l'équipe d'un responsable");
		System.out.println("6 - Modifier des parametres");
		System.out.println("7 - Supprimer entierement un employe");
	}

	public static void err() {
		System.out.println("Votre saisie n'est pas correcte");
	}

	public static void bye() {
		System.out.println("Au revoir");
	}

	public static void menu1() {
		System.out.println("----------------------------------");
		System.out.println("0 - Retour");
		System.out.println("1 - Creer un employe simple");
		System.out.println("2 - Creer un responsable");
		System.out.println("3 - Creer un commercial");
	}

	public static void creerEmp() {
		System.out.println("Entrez le nom d'employe que vous voulez creer");
		Scanner in = new Scanner(System.in);
		String nom = in.nextLine();

		Employe e = new Employe(nom, false);
		System.out.println("L'employe " + e.getMatricule() + " " + e.getNom() + " est cree");
	}

	public static void creerCom() {
		System.out.println("Entrez le nom de commercial que vous voulez creer");
		Scanner in = new Scanner(System.in);
		String nom = in.nextLine();

		Employe e = new Employe(nom, true);
		System.out.println("Le commercial " + e.getMatricule() + " " + e.getNom() + " est cree");
	}

	public static void creerRes() {
		System.out.println("Entrez le nom de responsable que vous voulez creer");
		Scanner in = new Scanner(System.in);
		String nom = in.nextLine();

		System.out.println("Est-il un commercial? true / false");
		Boolean isCom = in.nextBoolean();

		System.out.println("Entrez son niveau hierarchique dans l'entreprise");
		int niveau = in.nextInt();

		Responsable r = new Responsable(nom, isCom, niveau);
		listeResTotal.add(r);
		System.out.println("Le responsable " + r.getNom() + " Matricule : " + r.getMatricule()
				+ " Niveau hierarchique : " + niveau + " est cree");
	}

	public static void menu2() {
		System.out.println("----------------------------------");
		System.out.println("0 - Retour");
		System.out.println("1 - Afficher la liste des employes");
		System.out.println("2 - Afficher la liste des commerciaux");
		System.out.println("3 - Afficher la liste des responsables");
		System.out.println("4 - Afficher la liste total");
	}

	public static void menu3() {
		System.out.println("----------------------------------");
		System.out.println("0 - Retour");
		System.out.println("1 - Afficher la salaire d'un employe");
		System.out.println("2 - Afficher la salaire total de tous les employes");
	}

	public static void afficherSalaireId() {
		System.out.println("Entrez l'ID de la personne que vous cherchez");

		Scanner in = new Scanner(System.in);
		int nb = in.nextInt();

		if (nb > Employe.getCounter() || nb <= 0) {
			System.out.println("La personne que vous cherchez n'exsite pas");
		}

		for (Employe emp : Employe.getListeTotal()) {
			if (nb == emp.getMatricule()) {
				System.out.println("ID : " + emp.getMatricule() + "\tNom : " + emp.getNom() + "\tSalaire : "
						+ Employe.getBaseSalaire());
			}
		}
	}

	public static void afficherSalaire() {
		for (Employe emp : Employe.getListeTotal()) {
			if (Employe.getListeTotal().isEmpty()) {
				System.out.println("Il n'y a personne dans cette entreprise");
			} else {
				System.out.println("ID : " + emp.getMatricule() + "\tNom : " + emp.getNom() + "\tSalaire : "
						+ emp.calculSalaire());
			}
		}
	}

	public static void menu4() {
		System.out.println("----------------------------------");
		System.out.println("0 - Retour");
		System.out.println("1 - Ajouter un employe d'une équipe d'un responsable");
		System.out.println("2 - Supprimer un employe d'une équipe d'un responsable");
	}

	public static void ajouterEmpARes() {
		System.out.println("Entrer l'ID de responsable");
		Scanner in = new Scanner(System.in);
		int idRes = in.nextInt();

		ArrayList<Responsable> al = Responsable.getListeResTotal();

		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getMatricule() == idRes) {
				System.out.println("Entre l'ID d'employe que vous voulez ajouter dans ce responsable");
				int idEmp = in.nextInt();
				if (al.get(i).isCom()) {
					for (Employe employe : Employe.getListeTotal()) {
						if (employe.getMatricule() == idEmp && employe.getNiveau() < al.get(i).getNiveau()) {
							al.get(i).addSub(employe);
							System.out.println(
									employe.getNom() + " est bien ajoute dans l'equipe de " + al.get(i).getNom());
							return;
						} else {
							System.out.println(
									"Cet employe ne peux pas etre ajoute dans l'equie de " + al.get(i).getNom());
							return;
						}
					}
				} else {
					for (Employe employe : Employe.getListeTotal()) {
						if (employe.getMatricule() == idEmp && employe.getNiveau() < al.get(i).getNiveau()
								&& !employe.isCom()) {
							al.get(i).addSub(employe);
							System.out.println(
									employe.getNom() + " est bien ajoute dans l'equipe de " + al.get(i).getNom());
							return;
						}

					}
					System.out.println("Cet employe ne peux pas etre ajoute dans l'equie de " + al.get(i).getNom());
					return;
				}
			}
		}
		System.out.println("Cet responsable n'existe pas");
	}

	public static void afficherEquipe() {
		System.out.println("Entrer l'ID de responsable");
		Scanner in = new Scanner(System.in);
		int idRes = in.nextInt();

		for (Responsable responsable : Responsable.getListeResTotal()) {
			if (responsable.getMatricule() == idRes) {
				if (responsable.getListeResSub().isEmpty()) {
					System.out.println("Il n'y a pas d'equipe pour " + responsable.getNom());
					return;
				} else {
					System.out.println("L'equipe de " + responsable.getNom());
					responsable.getListeResSubPrint();
					return;
				}
			}
		}
		System.out.println("Cet responsable n'existe pas");

	}

	public static void supprimerEmp() {
		System.out.println("Entrer l'ID de responsable");
		Scanner in = new Scanner(System.in);
		int idRes = in.nextInt();

		for (Responsable responsable : Responsable.getListeResTotal()) {
			if (responsable.getMatricule() == idRes) {
				if (responsable.getListeResSub().isEmpty()) {
					System.out.println("Responsable " + responsable.getNom() + " n'a pas d'equipe");
					return;
				} else {
					System.out.println("L'equipe de " + responsable.getNom());
					responsable.getListeResSubPrint();
					System.out.println("Entre l'ID d'employe que vous voulez supprimer");
					int idEmp = in.nextInt();
					for (int i = 0; i < responsable.getListeResSub().size(); i++) {
						if (responsable.getListeResSub().get(i).getMatricule() == idEmp) {
							responsable.getListeResSub().remove(i);
							System.out.println(responsable.getListeResSub().get(i).getNom()
									+ " est supprime de l'equipe " + responsable.getNom());
							return;
						} else {
							System.out.println("Cette employe n'est pas dans l'equipe de " + responsable.getNom());
							return;
						}
					}
				}
			} else {
				System.out.println("Cet responsable n'existe pas");
			}
		}
	}

	public static void menu6() {
		System.out.println("----------------------------------");
		System.out.println("0 - Retour");
		System.out.println("1 - Modifier l'indice salarial d'un employé");
		System.out.println("2 - Modifier la valeur fixe des salaires des employés");
		System.out.println("3 - Modifier le nombre de vente d'un commercial");
	}

	public static void modifierIndiceSal() {
		System.out.println("Entrer l'ID de l'employe");
		Scanner in = new Scanner(System.in);
		int idEmp = in.nextInt();

		for (Employe employe : Employe.getListeTotal()) {
			if (employe.getMatricule() == idEmp) {
				System.out.println("Entre l'indice salarial pour " + employe.getNom());
				int indice = in.nextInt();
				employe.setIndiceSalarial(indice);
				System.out.println("Le nombre de vente pour " + employe.getNom() + " est " + indice);
			} else {
				System.out.println("Cet employe n'exsite pas");
			}
		}

	}

	public static void modifierBaseSal() {
		System.out.println("Entre le nouveau base salaire");
		Scanner in = new Scanner(System.in);
		int baseSal = in.nextInt();
		Employe.setBaseSalaire(baseSal);
		System.out.println("Le base salaire a ete modifie a " + baseSal);
	}

	public static void modifierNbVente() {
		System.out.println("Entrer l'ID de commercial");
		Scanner in = new Scanner(System.in);
		int idCom = in.nextInt();

		for (Employe commercial : Employe.getListeCom()) {
			if (commercial.getMatricule() == idCom) {
				System.out.println("Entre le nombre de vente pour le commercial " + commercial.getNom());
				int nbVente = in.nextInt();
				commercial.setNbVente(nbVente);
				System.out.println("Le nombre de vente pour " + commercial.getNom() + " est " + nbVente);
			}
		}

		for (Employe commercial : Responsable.getListeResCom()) {
			if (commercial.getMatricule() == idCom) {
				System.out.println("Entre le nombre de vente pour le commercial " + commercial.getNom());
				int nbVente = in.nextInt();
				commercial.setNbVente(nbVente);
				System.out.println("Le nombre de vente pour " + commercial.getNom() + " est " + nbVente);
			}
		}
	}

	public static void supprimer() {
		System.out.println("Entrer l'ID de l'employe que vous voulez supprimer");
		Scanner in = new Scanner(System.in);
		int idEmp = in.nextInt();

		for (Employe employe : Employe.getListeTotal()) {
			if (employe.getMatricule() == idEmp) {
				if (employe instanceof Responsable) {

					for (Responsable responsable : Responsable.getListeResTotal()) {
						if (responsable.getListeResSub().isEmpty()) {
							for (int i = 0; i < Responsable.getListeResTotal().size(); i++) {
								for (Responsable res : Responsable.getListeResTotal()) {
									res.getListeResSub().remove(responsable);
								}
								if (Responsable.getListeResTotal().get(i).equals(responsable)) {
									Responsable.getListeResTotal().remove(i);
									if (!Responsable.getListeRes().isEmpty()) {
										Responsable.getListeRes().remove(responsable);
									}
									if (!Responsable.getListeResCom().isEmpty()) {
										Responsable.getListeResCom().remove(responsable);
									}
									System.out.println("Responsable " + responsable.getNom() + " est supprime");
									return;
								}
							}
						} else {
							for (Responsable res : Responsable.getListeResTotal()) {
								if (res.getListeResSub().contains(responsable)) {

									res.getListeResSub().remove(responsable);

									Responsable.getListeResTotal().remove(responsable);
									res.getListeResSub().addAll(responsable.getListeResSub());
									if (!Responsable.getListeRes().isEmpty()) {
										Responsable.getListeRes().remove(responsable);
									}
									if (!Responsable.getListeResCom().isEmpty()) {
										Responsable.getListeResCom().remove(responsable);
									}

									System.out.println("Responsable " + responsable.getNom() + " est supprime");
									System.out.println("Son equipe maintenant est attache a " + res.getNom());
									return;

								} else {
									for (Responsable res2 : Responsable.getListeResTotal()) {
										res2.getListeResSub().remove(responsable);
									}
									Responsable.getListeResTotal().remove(responsable);

									if (!Responsable.getListeRes().isEmpty()) {
										Responsable.getListeRes().remove(responsable);
									}
									if (!Responsable.getListeResCom().isEmpty()) {
										Responsable.getListeResCom().remove(responsable);
									}
									System.out.println("Responsable " + responsable.getNom() + " est supprime");
									System.out.println(responsable.getNom()
											+ " est attache a personne\nSon equipe maintenant est dispersee");
									return;
								}
							}
						}
					}
				} else {
					for (Responsable res : Responsable.getListeResTotal()) {
						res.getListeResSub().remove(employe);
					}
					for (int i = 0; i < Employe.getListeTotal().size(); i++) {
						if (Employe.getListeTotal().get(i).equals(employe)) {
							Employe.getListeTotal().remove(i);
							if (!Employe.getListeEmp().isEmpty())
								Employe.getListeEmp().remove(employe);
						}
						if (!Employe.getListeCom().isEmpty())
							Employe.getListeCom().remove(employe);
					}
					System.out.println(employe.getNom() + " est supprime");
					return;
				}
			}
		}
		System.out.println("Cette personne n'existe pas");
	}
}
