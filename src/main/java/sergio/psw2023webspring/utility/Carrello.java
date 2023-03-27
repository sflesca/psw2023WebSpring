package sergio.psw2023webspring.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Carrello {


    private int count = 0;

    public int getCount() {
        return count;
    }

    public void inc(){
        count++;
    }
}
