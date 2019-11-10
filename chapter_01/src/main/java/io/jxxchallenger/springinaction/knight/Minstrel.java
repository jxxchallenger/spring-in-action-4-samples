package io.jxxchallenger.springinaction.knight;

import java.io.PrintStream;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Minstrel {

    private PrintStream printStream;

    public Minstrel(@Value(value = "#{T(System).out}") PrintStream printStream) {
        super();
        this.printStream = printStream;
    }
    
    @Pointcut(value = "execution(* *.embarkOnQuest(..))")
    public void pointcut() {
        
    }
    
    @Before(value = "pointcut()")
    public void singBeforeQuest() {
        this.printStream.println("Fa la la, the knight is so brave!");
    }
    
    @After(value = "pointcut()")
    public void singAfterQuest() {
        this.printStream.println("Tee hee hee, the brave knight did embark on a quest!");
    }
}
