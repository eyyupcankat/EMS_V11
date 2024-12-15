package dataStructure;

import personel.Personel;

public class BagliListe {
		Personel bas;
		Personel son;

		
		public BagliListe(){
			bas=null;
			son=null;
		}
		
		public void Sil(Personel silPersonel) {
			if (bas == null) {
				System.out.println("kardes zaten bos bu");
			}else {
				Personel temp = bas;
				
				 while(temp!= null) {
	
					 if(temp.getMaas() == silPersonel.getMaas()) {
						 if(bas==son) {
							 bas=null;
							 son=null;
						 }
						 
						 if(silPersonel.sonraki == null && bas!=son) {
							 son=temp.onceki;
							 temp.onceki.sonraki = null;
						 }
						 else if(silPersonel.sonraki!=null) {
							 temp.onceki.sonraki=temp.sonraki;
							 temp.sonraki.onceki=temp.onceki;
						 }
				 }
					 temp=temp.sonraki;
				 
				 }
			}
			
		}
		
		public void Ekle(Personel yeni) {
			
			if(bas==null) {//liste boşsa
				bas=yeni;
				son=yeni;
				System.out.println("başa ekledim");
				return;
			}
			//liste boş değil
			
			son.sonraki=yeni;
			System.out.println("baştan sonraya ekledim");
			Personel temp=son;
			//son.onceki=son;
			son=yeni;
			son.onceki=temp;
			 
		}
		
		public void guncelleme(Personel guncellePersonel,long maas,String isim,String soyisim,String pozisyon,int yas) {
			Personel temp = bas;
			while(temp !=null) {
				if(guncellePersonel.getMaas() == temp.getMaas()) {
					temp.setMaas(maas);
					temp.setIsim(isim);
					temp.setSoyisim(soyisim);
					temp.setPozisyon(pozisyon);
					temp.setYas(yas);
				}
				temp=temp.sonraki;
			}
		}
		
		
		
		
		
		public void listeYazdir() {
			
			Personel temp =bas;
			while(temp!=null) {
				
				System.out.println(temp.getMaas()+" "+temp.getIsim()+" "+temp.getSoyisim()+" "+temp.getPozisyon()+" "+temp.getYas());
				temp = temp.sonraki;
				
			}
			System.out.println("--------------------");
		}
		 

}