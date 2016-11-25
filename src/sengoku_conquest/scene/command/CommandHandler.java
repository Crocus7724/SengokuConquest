package sengoku_conquest.scene.command;


/**
 * Created by Yamamoto on 2016/11/24.
 */
public abstract class CommandHandler<T,R> {
    protected abstract R execute(T parameter);

    @SuppressWarnings("unchecked")
    public R doExecute(T parameter){
        return execute(parameter);
    }

    public abstract String getCommandName();
}
