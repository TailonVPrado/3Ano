package br.com.unipar.hibernateteste;

import br.com.unipar.hibernateteste.model.util.EntityManagerUtil;
import br.com.unipar.hibernateteste.model.util.PetDoguiLog;

public class HibernateTeste {

    
    public static void main(String[] args) {

        EntityManagerUtil.getEntityManagerFactory();
        
        MenuPetDogui tela = new MenuPetDogui();
        tela.setVisible(true);

        PetDoguiLog.infoGeral("TESTE LOG");
    }
}
