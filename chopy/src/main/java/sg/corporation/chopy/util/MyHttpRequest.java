package sg.corporation.chopy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpRequest {

	public static String makeGetHttpRequest(String myUrl, UtilitaryInterface utilitaryInterface) {
		String myData = "";
		try {
            // Créez l'URL de la ressource que vous souhaitez récupérer
            URL url = new URL(myUrl);

            // Ouvrez une connexion HTTP avec l'URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configurez la méthode de requête (GET dans cet exemple)
            conn.setRequestMethod("GET");

            // Obtenez la réponse
            int responseCode = conn.getResponseCode();

            if (responseCode == 200) { // 200 OK
                // Lisez la réponse du serveur
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                myData = in.readLine();
                in.close();
                conn.disconnect();

                // Affichez la réponse
            } else {
            	conn.disconnect();
            	myData = "La requête a renvoyé un code d'erreur : " + responseCode;
            }

            // Fermez la connexion
        } catch (IOException e) {
            e.printStackTrace();
        }
		utilitaryInterface.utilitaryMethod("Json de la requète http");
		return myData;
	}
}