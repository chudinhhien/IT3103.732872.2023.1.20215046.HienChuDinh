package hust.soict.dsai.aims.store;

import java.util.Scanner;
import java.util.Comparator;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting the AIMS application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() {
        storeMenu();
        int choice;

        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 0);
    }
    
    public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
    }


    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-" + (media instanceof Playable ? "2" : ""));
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                addToCart(media);
                break;
            case 2:
                if (media instanceof Playable) {
                    ((Playable) media).play();
                }
                break;
            case 0:
                System.out.println("Returning to the previous menu.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    public static void addToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media != null) {
            addToCart(media);
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void addToCart(Media media) {
        cart.addMedia(media);
        System.out.println("Added successfully!");
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Playable media not found with title: " + title);
        }
    }

    public static void updateStore() {
        updateStoreMenu();
        int choice;

        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 0);
    }

    private static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void addMediaToStore() {
        // Implement the logic to add media to the store
        // You may need to create instances of Media (Book, CompactDisc, DigitalVideoDisc, etc.) and add them to the store.
        // Example: store.addMedia(new Book(1, "Book Title", "Book Category", 19.99f));
    }

    private static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove from the store: ");
        String title = scanner.nextLine();

        Media media = findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from the store.");
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void seeCurrentCart() {
        cartMenu();
        int choice;

        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaFromCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediasInCart() {
        // Implement the logic to filter medias in the cart
        System.out.println("Options for filtering:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.print("Please choose a number: ");
        int filterChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (filterChoice) {
            case 1:
                System.out.print("Enter media ID to filter: ");
                int filterId = scanner.nextInt();
                cart.filterById(filterId);
                break;
            case 2:
                System.out.print("Enter media title to filter: ");
                String filterTitle = scanner.nextLine();
                cart.filterByTitle(filterTitle);
                break;
            case 0:
                System.out.println("Returning to the cart menu.");
                break;
            default:
                System.out.println("Invalid choice. Returning to the cart menu.");
        }
    }

    public static void sortMediasInCart() {
        // Implement the logic to sort medias in the cart using the custom comparator
        System.out.println("Options for sorting:");
        System.out.println("1. Sort by Title then Cost");
        System.out.println("2. Sort by Cost then Title");
        System.out.println("0. Back");
        System.out.print("Please choose a number: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Comparator<Media> comparator;
        switch (sortChoice) {
            case 1:
                comparator = Media.COMPARE_BY_TITLE_COST;
                break;
            case 2:
                comparator = Media.COMPARE_BY_COST_TITLE;
                break;
            case 0:
                System.out.println("Returning to the cart menu.");
                return;
            default:
                System.out.println("Invalid choice. Returning to the cart menu.");
                return;
        }

        cart.sortMedia(comparator);
        System.out.println("Medias in the cart sorted.");
    }


    public static void removeMediaFromCart() {
        // Implement the logic to remove media from the cart
        System.out.print("Enter the title of the media to remove from the cart: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from the cart.");
        } else {
            System.out.println("Media not found with title: " + title);
        }
    }

    public static void playMediaFromCart() {
        // Implement the logic to play media from the cart
        System.out.print("Enter the title of the media to play from the cart: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Playable media not found with title: " + title);
        }
    }

    public static void placeOrder() {
        // Implement the logic to place an order
        cart.placeOrder();
        System.out.println("Order placed. Cart is now empty.");
    }

    private static Media findMediaByTitle(String title) {
        // Implement the logic to find media by title in the store
        return store.findMediaByTitle(title);
    }

}