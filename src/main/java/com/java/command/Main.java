package com.java.command;

public class Main {
}
class Content{
    String msg;
}
abstract class Command{
    abstract void  exec();
    abstract void undo();
}
class InsertCommand extends Command{

    Content c;
    String strToInsert = "http://wwww.sunbenjin.online";
    public InsertCommand(Content c){
        this.c = c;
    }
    @Override
    void exec() {
        c.msg = c.msg+strToInsert;
    }

    @Override
    void undo() {
        c.msg = c.msg.substring(0,c.msg.length()-strToInsert.length());
    }
}
class CopyCommand extends Command{

    Content c;
    public CopyCommand(Content c){
        this.c = c;
    }
    @Override
    void exec() {
        c.msg = c.msg+c.msg;
    }

    @Override
    void undo() {
        c.msg = c.msg.substring(0,c.msg.length()*2);
    }
}
class DeletedCommand extends Command{

    Content c;
    String deleted;

    public DeletedCommand(Content c) {
        this.c = c;
    }

    @Override
    void exec() {
        deleted = c.msg.substring(0,5);
        c.msg = c.msg.substring(5,c.msg.length());
    }

    @Override
    void undo() {

        c.msg = deleted+c.msg;
    }
}
