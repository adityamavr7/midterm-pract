/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 * Updated 2015 Mark Russell <mark.russell@lambtoncollege.ca>s
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */
@WebServlet("/note")
public class NoteServlet extends HttpServlet {
            
    protected void doGET(HttpServletRequest request,HttpServletResponse response) throws IOException{
       
        model.Note note=new model.Note();
        try(PrintWriter out=response.getWriter()){
            out.println(note.getNote());
        }catch(IOException ex){
            System.err.println("Error Message :"+ex.getMessage());
        }
        response.setHeader("Cache-Control","private,no-store,no-cache,must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
    }
    
    protected void doPOST(HttpServletRequest request,HttpServletResponse response) throws IOException {
        
        
        model.Note note=new model.Note();
        
        try(PrintWriter out=response.getWriter()){
         String text="";
         String add="";
         String clear="";
         text=request.getParameter("addNote");
         note.addNote(text);
         String note1=note.getNote();
        
         add=request.getParameter("add");
         clear=request.getParameter("clear");
            if(!(text.isEmpty())){
                 note.setNote(text);
            }
            if(!(add.isEmpty())){
                note.addNote(add);
            }
            if(clear.equals("true")){
                note.clear();
            }
        
    
    
    }
}
 
}
