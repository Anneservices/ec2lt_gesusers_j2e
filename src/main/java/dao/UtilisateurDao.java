package dao;

import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao
{
	private static int LastId = 0;
	
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	static {
		utilisateurs.add(new Utilisateur("Super", "User", "admin", "passer"));
	}
	
//	static
//	{
//		utilisateurs.add(new Utilisateur(1, "Ndiaye", "Fatou", "fafa", "passer"));
//		utilisateurs.add(new Utilisateur(2, "Mar", "ElHadji", "aladji", "partir"));
//		utilisateurs.add(new Utilisateur(3, "Mendy", "Ismail", "iso", "repasser"));
//		utilisateurs.add(new Utilisateur(4, "Mbaye", "Momar", "momo", "aller"));
//	}
	
	public static ArrayList<Utilisateur> lister()
	{
		return utilisateurs;
	}
	
	public static boolean ajouter(Utilisateur utilisateur)
	{
		LastId++;
		utilisateur.setId(LastId);
		utilisateurs.add(utilisateur);
		
		return true;
	}
	
	public static boolean supprimer(int id)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getId() == id)
			{
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		
		return false;
	}
	
	public static Utilisateur get(String login)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getLogin().equals(login))
			{
				return utilisateur;
			}
		}
		
		return null;
	}

	public static boolean modifier(Utilisateur user)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getId() == user.getId())
			{
				utilisateur.setNom(user.getNom());
				utilisateur.setPrenom(user.getPrenom());
				utilisateur.setLogin(user.getLogin());
				utilisateur.setPassword(user.getPassword());
				
				return true;
			}
		}
		
		return false;
		
	}
}
