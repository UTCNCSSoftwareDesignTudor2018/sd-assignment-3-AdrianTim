package com.Assig3.Assig3.BusinessLogic.Implementations;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;
import com.Assig3.Assig3.BusinessLogic.ObservableDP.Observer;

import javax.websocket.EncodeException;
import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

public class OnlineReader implements Observer{

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public OnlineReader(Session session) {
        this.session = session;
    }

    @Override
    public void update(List<ArticleDTO> newArticle) {

        try {
            this.session.getBasicRemote().sendObject(newArticle);
        } catch (IOException | EncodeException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OnlineReader that = (OnlineReader) o;

        return session != null ? session.equals(that.session) : that.session == null;
    }

    @Override
    public int hashCode() {
        return session != null ? session.hashCode() : 0;
    }
}
