package com.ciclo3.usa.ciclo3.service;

import com.ciclo3.usa.ciclo3.model.Message;
import com.ciclo3.usa.ciclo3.repository.messageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class messageService {
    
    @Autowired
    private messageRepository MessageRepository;

    public List<Message> getAllMessage() {
        return (List<Message>) MessageRepository.getAllMessage();
    }
    public Optional<Message> getMessage(int id) {
        return MessageRepository.getMessage(id);
    }
    public Message saveMessage(Message message) {
        if(message.getidMessage() == null){
            return MessageRepository.saveMessage(message);
        }
        else{
            Optional<Message> messageAux = MessageRepository.getMessage(message.getidMessage());
            if(messageAux.isEmpty()){
                return MessageRepository.saveMessage(message); 
            }else{
                return message;
            }
        }
        
    }

    public Message update(Message mensaje) {
        if (mensaje.getidMessage() != null) {
            Optional<Message> mensajetAux = MessageRepository.getMessage(mensaje.getidMessage());
            if (mensaje.getmessageText() != null) {
                mensajetAux.get().setmessageText(mensaje.getmessageText());
            }
            if (mensaje.getclient() != null) {
                mensajetAux.get().setclient(mensaje.getclient());
            }
            if (mensaje.getcar() != null) {
                mensajetAux.get().setcar(mensaje.getcar());
            }
            return MessageRepository.saveMessage(mensajetAux.get());
        }
        return mensaje;
    }

    public boolean deleteMessage(int IdMensaje) {
        Boolean aBoolean = getMessage(IdMensaje).map(mensaje ->{
            MessageRepository.deleteMessage(mensaje);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
