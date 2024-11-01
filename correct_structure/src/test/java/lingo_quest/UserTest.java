package lingo_quest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class UserTest {
    private User defaultUser = new User();
    private User parameterizedUser = new User();
    private UUID testItemID;
    private UUID testFriendID;
    private Lesson lesson = new Lesson();

    @BeforeEach
    public void setup() {
        defaultUser = new User();
        parameterizedUser = new User("testUser", "testPassword123");
        testItemID = UUID.randomUUID();
        testFriendID = UUID.randomUUID();
        lesson = new Lesson();
    }

    @AfterEach
    public void tearDown() {
        //defaultUser = null;
        //parameterizedUser = null;
    }

    // Tests for User Constructors
    @Test
    public void testDefaultConstructorUUIDNotNull() {
        assertNotNull(defaultUser.getUUID());
    }

    @Test
    public void testParameterizedConstructorSetsUsername() {
        assertEquals("testUser", parameterizedUser.getUsername());
    }

    @Test
    public void testParameterizedConstructorSetsPassword() {
        assertEquals("testPassword123", parameterizedUser.getPassword());
    }

    // setUserDictionary
    @Test
    public void testSetUserDictionaryValidDictionary() {
        Dictionary dictionary = new Dictionary();
        defaultUser.setUserDictionary(dictionary);
        assertEquals(dictionary, defaultUser.getUserDictionary());
    }

    @Test
    public void testSetUserDictionaryNull() {
        defaultUser.setUserDictionary(null);
        assertNull(defaultUser.getUserDictionary());
    }

    @Test
    public void testSetUserDictionaryUpdatesDictionaryID() {
        Dictionary dictionary = new Dictionary();
        defaultUser.setUserDictionary(dictionary);
        assertEquals(dictionary.getID(), defaultUser.getUserDictionaryID());
    }

    @Test
    public void testSetUserDictionaryMaintainsNonNullDictionary() {
        Dictionary dictionary = new Dictionary();
        defaultUser.setUserDictionary(dictionary);
        defaultUser.setUserDictionary(null);
        assertEquals(dictionary, defaultUser.getUserDictionary());
    }

    @Test
    public void testSetUserDictionaryReplacesPreviousDictionary() {
        Dictionary firstDictionary = new Dictionary();
        Dictionary secondDictionary = new Dictionary();
        defaultUser.setUserDictionary(firstDictionary);
        defaultUser.setUserDictionary(secondDictionary);
        assertEquals(secondDictionary, defaultUser.getUserDictionary());
    }

    // addCoins
    @Test
    public void testAddCoinsIncreasesCoinBalance() {
        defaultUser.addCoins(100);
        assertEquals(100, defaultUser.getCoinBalance());
    }

    @Test
    public void testAddCoinsIncreasesCoinsEarned() {
        defaultUser.addCoins(100);
        assertEquals(100, defaultUser.getCoinsEarned());
    }

    @Test
    public void testAddCoinsMultipleCalls() {
        defaultUser.addCoins(50);
        defaultUser.addCoins(50);
        assertEquals(100, defaultUser.getCoinBalance());
    }

    @Test
    public void testAddCoinsZeroCoins() {
        defaultUser.addCoins(0);
        assertEquals(0, defaultUser.getCoinBalance());
    }

    @Test
    public void testAddCoinsNegativeValue() {
        defaultUser.addCoins(-50);
        assertEquals(-50, defaultUser.getCoinBalance());
    }

    // set coins
    @Test
    public void testSpendCoinsDecreasesCoinBalance() {
        defaultUser.addCoins(100);
        defaultUser.spendCoins(50);
        assertEquals(50, defaultUser.getCoinBalance());
    }

    @Test
    public void testSpendCoinsExceedsBalance() {
        defaultUser.addCoins(50);
        defaultUser.spendCoins(100);
        assertEquals(-50, defaultUser.getCoinBalance());
    }

    @Test
    public void testSpendCoinsMultipleCalls() {
        defaultUser.addCoins(100);
        defaultUser.spendCoins(30);
        defaultUser.spendCoins(20);
        assertEquals(50, defaultUser.getCoinBalance());
    }

    @Test
    public void testSpendCoinsZeroAmount() {
        defaultUser.addCoins(100);
        defaultUser.spendCoins(0);
        assertEquals(100, defaultUser.getCoinBalance());
    }

    @Test
    public void testSpendCoinsNegativeAmount() {
        defaultUser.addCoins(100);
        defaultUser.spendCoins(-50);
        assertEquals(150, defaultUser.getCoinBalance());
    }

    // owns item
    @Test
    public void testOwnsItemUserOwnsItem() {
        defaultUser.getItems().add(testItemID);
        assertTrue(defaultUser.ownsItem(testItemID));
    }

    @Test
    public void testOwnsItemUserDoesNotOwnItem() {
        assertFalse(defaultUser.ownsItem(testItemID));
    }

    @Test
    public void testOwnsItemMultipleItems() {
        UUID item2 = UUID.randomUUID();
        defaultUser.getItems().add(testItemID);
        defaultUser.getItems().add(item2);
        assertTrue(defaultUser.ownsItem(item2));
    }

    @Test
    public void testOwnsItemNullID() {
        assertFalse(defaultUser.ownsItem(null));
    }

    @Test
    public void testOwnsItemEmptyItemsList() {
        defaultUser.getItems().clear();
        assertFalse(defaultUser.ownsItem(testItemID));
    }

    // buy item
    @Test
    public void testBuyItemSuccess() {
        ItemShop shop = ItemShop.getInstance();
        Item item = new Item("Test Item", "A sample item", 50);
        shop.addItem(item);
        defaultUser.addCoins(100);
        assertTrue(defaultUser.buyItem(item.getID()));
    }

    @Test
    public void testBuyItemNotEnoughCoins() {
        ItemShop shop = ItemShop.getInstance();
        Item item = new Item("Expensive Item", "Costly item", 200);
        shop.addItem(item);
        defaultUser.addCoins(100);
        assertFalse(defaultUser.buyItem(item.getID()));
    }

    @Test
    public void testBuyItemAlreadyOwned() {
        defaultUser.getItems().add(testItemID);
        assertFalse(defaultUser.buyItem(testItemID));
    }

    @Test
    public void testBuyItemNonexistentItem() {
        UUID randomID = UUID.randomUUID();
        assertFalse(defaultUser.buyItem(randomID));
    }

    @Test
    public void testBuyItemNullID() {
        assertFalse(defaultUser.buyItem(null));
    }

    // search friends
    @Test
    public void testSearchFriendsExistingFriend() {
        defaultUser.getFriendsList().add(testFriendID);
        assertNotNull(defaultUser.searchFriends(testFriendID));
    }

    @Test
    public void testSearchFriendsNonexistentFriend() {
        UUID randomID = UUID.randomUUID();
        assertNull(defaultUser.searchFriends(randomID));
    }

    @Test
    public void testSearchFriendsNullID() {
        assertNull(defaultUser.searchFriends(null));
    }

    @Test
    public void testSearchFriendsMultipleFriends() {
        UUID friend2 = UUID.randomUUID();
        defaultUser.getFriendsList().add(testFriendID);
        defaultUser.getFriendsList().add(friend2);
        assertNotNull(defaultUser.searchFriends(friend2));
    }

    @Test
    public void testSearchFriendsEmptyFriendsList() {
        defaultUser.getFriendsList().clear();
        assertNull(defaultUser.searchFriends(testFriendID));
    }
}
