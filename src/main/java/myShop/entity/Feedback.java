
package myShop.entity;


import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private long id;
    @Column(name = "text")
    private String Text;
    @ManyToOne
    @JoinColumn(name = "feedback_user")
    private User feedbackUser;
    @ManyToOne
    @JoinColumn(name = "feedback_product")
    private Product feedbackProduct;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public User getFeedbackUser() {
        return feedbackUser;
    }

    public void setFeedbackUser(User feedbackUser) {
        this.feedbackUser = feedbackUser;
    }

    public Product getFeedbackProduct() {
        return feedbackProduct;
    }

    public void setFeedbackProduct(Product feedbackProduct) {
        this.feedbackProduct = feedbackProduct;
    }

    public Feedback() {

    }
}
