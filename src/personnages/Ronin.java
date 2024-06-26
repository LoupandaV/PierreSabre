package personnages;

public class Ronin extends Humain {
	private int honneur=1;
	
	
	public Ronin(String nom,String boisson,int argent) {
		super(nom,boisson,argent);
	
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDonner= getArgent()/10;
		perdreArgent(argentDonner);
		parler(beneficiaire.getNom()+" prend ces "+argentDonner+" sous.");
		beneficiaire.recevoir(argentDonner);
		
	}
	
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouv� vermine, tu vas payer pour ce que tu as fait � ce pauvre marchand!");
		if (adversaire.getReputation() < (honneur*2)) {
			parler("Je t�ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			honneur+=1;
			
		}
		else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup");
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
		}
		
	}
	
	

}
