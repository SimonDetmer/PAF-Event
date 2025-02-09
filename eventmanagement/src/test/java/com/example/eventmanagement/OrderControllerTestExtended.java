@WebMvcTest(OrderController.class)
public class OrderControllerTestExtended {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testCreateOrder() throws Exception {
        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"userId\": 1, \"eventId\": 2, \"ticketIds\": [10, 11] }"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCancelOrder() throws Exception {
        mockMvc.perform(delete("/orders/5"))
                .andExpect(status().isOk());
    }
}
