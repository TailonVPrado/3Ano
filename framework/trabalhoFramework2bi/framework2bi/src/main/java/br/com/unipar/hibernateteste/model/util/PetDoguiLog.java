package br.com.unipar.hibernateteste.model.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PetDoguiLog {

    private static final String GERAL = "br.com.unipar.hibernateteste";
    private static final String PERSISTENCIA = "br.com.unipar.hibernateteste.model.dao";
    
    private static Logger logGERAL = LogManager.getLogger(GERAL);
    private static Logger logPERSISTENCIA = LogManager.getLogger(PERSISTENCIA);
    
    public static void infoGeral(String msg) {
        logGERAL.info("========INICIO DA MENSAGEM DE INFO GERAL========");
        logGERAL.info("========"+msg);
        logGERAL.info("========FIM DA MENSAGEM DE INFO GERAL========");
    }
    
    public static void erroGeral(Exception ex){
        logGERAL.info("========INICIO DA MENSAGEM DO ERRO GERAL========");
        logGERAL.error(ex.getMessage());
        for(StackTraceElement el : ex.getStackTrace())
                logGERAL.info("========"+el.toString()+"========");
        logGERAL.info("========FIM DA MENSAGEM DO ERRO GERAL========");
    }
}
