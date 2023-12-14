public class Welcome extends Message{
    @Override
    public void PrintWelcome(){
        System.out.println("""
                              ____            _    ____  _     _     _     
                             / __| _   _ ___| | _| __ )| |   (_)___| |_  
                             \\___ \\| | | / _| |/ /  _ \\| |   | / __| ' \\ 
                              __) | |_| \\_ \\   <| |) | |___| \\_ \\ | | |
                             |____/ \\__,_|___/_|\\_\\____/|_____|_|___/_| |_|""");
        System.out.println("Welcome to the program with Java!");
    }
}