package lcy.android.retrofit_config.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kaushik on 30/6/17.
 * model class for the GET requests
 */

public class GetModel {

    private String page;

    @SerializedName("per_page")
    private String perPage;

    private String total;

    @SerializedName("total_pages")
    private String total_pages;

    private List<Data> data;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GetModel{" +
                "page='" + page + '\'' +
                ", perPage='" + perPage + '\'' +
                ", total='" + total + '\'' +
                ", total_pages='" + total_pages + '\'' +
                ", data=" + data +
                '}';
    }

    class Data {

        private String id;

        @SerializedName("first_name")
        private String firstName;

        @SerializedName("last_name")
        private String lastname;

        private String avatar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }
}
