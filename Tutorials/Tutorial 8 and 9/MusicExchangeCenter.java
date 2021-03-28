import java.util.*;

public class MusicExchangeCenter {

    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter() {
        users = new ArrayList<>();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> onlines = new ArrayList<>();
        for (User u: users) {
            if (u.isOnline()) {
                onlines.add(u);
            }
        }
        return onlines;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        for (User u: users) {
            if (u.isOnline()) {
                for (Song s: u.getSongList()) {
                    songs.add(s);
                }
            }
        }
        return songs;
    }

    public String toString() {
        return "Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " songs available)";
    }

    public ArrayList<User> userWithName(String s) {
        ArrayList<User> uWN = new ArrayList<>();
        for (User u: users) {
            if (u.getUserName().equals(s)) {
                uWN.add(u);
            }
        }
        return uWN;
    }

    public void registerUser(User x) {
        if (userWithName(x.getUserName()) != null) {
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist) {
        ArrayList<Song> aSBA = new ArrayList<>();
        for (Song s: allAvailableSongs()) {
            if (s.getArtist().equals(artist)) {
                aSBA.add(s);
            }
        }
        return aSBA;
    }

    public Song getSong(String title, String ownerName) {
        for (User u: onlineUsers()) {
            if (u.getUserName().equals(ownerName)) {
                for (Song s: u.getSongList()) {
                    if (s.getTitle().equals(title)) {
                        downloadedSongs.add(s);
                        return s;
                    }
                }
            }
        }
        return null;
    }

    public void displayRoyalties() {
        System.out.println("Amount     Artist");
        System.out.println("-----------------");
        HashMap<String, Float> royalties = new HashMap<>();
        for (Song s: downloadedSongs) {
            if (royalties.containsKey(s.getArtist())) {
                royalties.put(s.getArtist(), royalties.get(s.getArtist()) + 0.25f);
            } else {
                royalties.put(s.getArtist(), 0.25f);
            }
        }
        for (HashMap.Entry<String, Float> entry : royalties.entrySet()) {
            System.out.println(String.format("$%1.2f" + "   " + entry.getKey(), entry.getValue()));
        }
    }

    public TreeSet<Song> uniqueDownloads() {
        TreeSet<Song> uniqueDownloads = new TreeSet<Song>(new Comparator<Song>() {
            public int compare(Song s1, Song s2) { return s1.getTitle().compareTo(s2.getTitle()); }
        });
        uniqueDownloads.addAll(downloadedSongs);
        return uniqueDownloads;
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity() {
        ArrayList<Pair<Integer, Song>> popularity = new ArrayList<Pair<Integer, Song>>();
        for (Song s: uniqueDownloads()) {
            popularity.add(new Pair<Integer, Song>((int)(royalties.get(s.getTitle())/0.25), s));
        }
        Collections.sort(popularity, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return -(p1.getKey() - p2.getKey());
            }
        });
        return popularity;
    }

    public ArrayList<Song> getDownloadedSongs() { return downloadedSongs; }
    public HashMap<String, Float> getRoyalties() { return royalties; }
}
