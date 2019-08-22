package com.cao.Command;

import com.cao.Databases.Database;
import com.cao.Databases.Permanent;
import com.cao.Procotol.Protocolcode;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class LPOPCommand implements Command {
    Database database = Database.getDatabase();
    List<Object> args;
    @Override
    public void run(OutputStream write) {
        //接受到的列表 拆解

        if(args.size() == 1) {
            String key  = new String((byte[]) args.get(0));
            List<String> dateList = database.getList(key);
            try {
                String value =Database.getList(key).remove(0);
                Protocolcode.writeBulkString(write,value);
                Permanent.getPermanent().clearListProfile();
                Permanent.getPermanent().writetoListProfile();
            } catch ( Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Protocolcode.writeError(write, "Wrong Format");
            } catch (IOException e ) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }
}
