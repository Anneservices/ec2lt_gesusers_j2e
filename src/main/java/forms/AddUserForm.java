package forms;

import java.util.HashMap;
import java.util.Map;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm
{
	private static final String CHAMP_NOM 		   = "nom";
	private static final String CHAMP_PRENOM 	   = "prenom";
	private static final String CHAMP_LOGIN 	   = "login";
	private static final String CHAMP_PASSWORD 	   = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	private Map<String, String> erreurs;
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private Utilisateur utilisateur;
	{
		
	}
	
	public AddUserForm(HttpServletRequest request)
	{
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter()
	{
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		this.validerPasswords();
		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		
		this.statusMessage = "Echec de l'ajout !";
		this.status = false;
		
		if (this.erreurs.isEmpty())
		{
			if (UtilisateurDao.ajouter(utilisateur)) 
			{
				this.statusMessage = "Ajout effectué avec succès !";
				this.status = true;
			}
		}
		
		return this.status;
	}
	
	private String getParameter(String parametre)
	{
		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.isBlank())
		{
			return null;
		}
		
		return valeur.trim();
	}
	
	private void validerChamps(String... champs)
	{
		for (String champ : champs)
		{
			if (this.getParameter(champ) == null)
			{
				this.erreurs.put(champ, "Vous devez renseigner ce champ !");
			}
		}
	}
	
	private void validerPasswords()
	{
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		if (password != null && !password.equals(passwordBis))
		{
			this.erreurs.put(CHAMP_PASSWORD, "Les mots de passe ne sont pas conformes !");
			this.erreurs.put(CHAMP_PASSWORD_BIS, "Les mots de passe ne sont pas conformes !");
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean getStatus() {
		return status;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
}
