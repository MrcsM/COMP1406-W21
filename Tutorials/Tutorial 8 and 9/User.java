import java.util.ArrayList;

public class User {
  private String     userName;
  private boolean    online;

  private ArrayList<Song> songList;
  
  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<>();
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  public ArrayList<Song> getSongList() { return songList; }
  
  public String toString()  {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  public void addSong(Song s) {
    s.setOwner(this);
    songList.add(s);
  }

  public int totalSongTime() {
    int totalDuration = 0;

    for (int i = 0; i < songList.size(); i++) {
      totalDuration += songList.get(i).getDuration();
    }

    return totalDuration;
  }

  public void register(MusicExchangeCenter m) { m.registerUser(this); }

  public void logon() { this.online = true; }

  public void logoff() { this.online = false; }

  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m) {
    ArrayList<String> list = new ArrayList<>();
    list.add(String.format("%3s %-30s%-20s%-4s %-30s", "", "TITLE", "ARTIST", "TIME", "OWNER"));
    for (int i = 1; i < songList.size(); i++) {
      for (Song s : m.allAvailableSongs()) {
        list.add(String.format("%3s. %-30s%-20s%-4s %-30s", i, s.getTitle(), s.getArtist(), s.getMinutes() + ":" + s.getSeconds(), s.getOwner().getUserName()));
        i++;
      }
    }
    return list;
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
    ArrayList<String> SLBA = new ArrayList<>();
    SLBA.add(String.format("%3s %-30s%-20s%-4s %-30s", "", "TITLE", "ARTIST", "TIME", "OWNER"));
    for (int i = 1; i < m.availableSongsByArtist(artist).size(); i++) {
      for (Song s : m.availableSongsByArtist(artist)) {
        if (isOnline()) {
          SLBA.add(String.format("%3s. %-30s%-20s%-4s %-30s", i, s.getTitle(), s.getArtist(), s.getMinutes() + ":" + s.getSeconds(), s.getOwner().getUserName()));
          i++;
        }
      }
    }
    return SLBA;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
    Song DS = m.getSong(title, ownerName);
    if (DS != null) {
      this.addSong(new Song(DS.getTitle(), DS.getArtist(), DS.getMinutes(), DS.getSeconds()));
      if (m.getRoyalties().containsKey(DS.getTitle())) {
        m.getRoyalties().put(DS.getTitle(), m.getRoyalties().get(DS.getTitle()) + 0.25f);
      }
      else {
        m.getRoyalties().put(DS.getTitle(), 0.25f);
      }
    }
  }
}
