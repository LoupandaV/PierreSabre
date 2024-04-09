package personnages;

public class Yakuza extends Humain 
{
	private String clan;
	private int reputation=4;

	public Yakuza (String nom,String boisson,int argent,String clan) {
		super(nom,boisson , argent);
		this.clan=clan;
	}
		
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		int argentVoler= victime.seFaireExtorquer();
		gagnerArgent(argentVoler);
		reputation = getReputation() + 1;
		parler("J’ai piqué les "+argentVoler+" sous de "+victime.getNom()+
				" ce qui me fait "+argent+" sous dans ma poche. Hi ! Hi !");
		
	}

	public int perdre() {
		int argentPerdu=argent;
		perdreArgent(argentPerdu);
		reputation = getReputation() - 1;
		parler("J’ai perdu mon duel et mes "+argentPerdu+" sous, snif... J'ai déshonoré le clan de "+clan+".");
		return argentPerdu;
		
	}
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation = getReputation() + 1;
		parler("Ce ronin pensait vraiment battre "+getNom()+" du clan de "+clan+"? Je l'ai dépouillé de ses "+gain+" sous.");
		
	}


	public int getReputation() {
		return reputation;
	}

}
