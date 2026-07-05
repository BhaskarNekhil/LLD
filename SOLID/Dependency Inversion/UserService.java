public class UserService {
  private Fetch fetch;
    UserService(Fetch fetch) {
        this.fetch = fetch;
    }
    public void getData(String id)
    {
        fetch.get(id);
    }
    public void setFetch(Fetch fetch)
    {
        this.fetch = fetch;
    }
}
