package com.itdotaer.access.pojo;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/13.
 */
public class UserArticles {

        private _User user;
        private List<OneArticle> articles;

        public _User getUser() {
            return user;
        }
        public void setUser(_User user) {
            this.user = user;
        }

        public List<OneArticle> getArticles() {
            return articles;
        }

        public void setArticles(List<OneArticle> articles) {
            this.articles = articles;
        }
}
