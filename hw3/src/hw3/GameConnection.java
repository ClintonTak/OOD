package hw3;

import java.io.*;
import java.util.*;
public class GameConnection {
    private File f;
    private Map<String,Player> info;

    public GameConnection(String id) {
        f = new File(id);
        if (!f.exists())
            info = new HashMap<String, Player>();
        else {
            try {
                InputStream is = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(is);
                info = (Map<String,Player>) ois.readObject();
                ois.close();
            }
            catch (IOException ex) {
                System.out.println(ex);
                throw new RuntimeException("Bank file is corrupt");
            }
            catch (ClassNotFoundException ex) {
                System.out.println(ex);
                throw new RuntimeException("Serialization problem");
            }
        }
    }

    public Map<String, Player> getMap() {
        return info;
    }

    public void saveMap(Map<String,Player> m) {
        try {
            OutputStream os = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(m);
            oos.close();
        }
        catch (Exception ex) {
            throw new RuntimeException("bank file is corrupt");
        }
    }
}

