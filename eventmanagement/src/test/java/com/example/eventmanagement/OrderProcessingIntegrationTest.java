@SpringBootTest
@AutoConfigureMockMvc
public class OrderProcessingIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    @Transactional
    public void testOrderCreationWithTickets() throws Exception {
        Ticket ticket1 = new Ticket(new BigDecimal("30.00"), new AvailableState());
        Ticket ticket2 = new Ticket(new BigDecimal("40.00"), new AvailableState());
        ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"userId\": 1, \"eventId\": 2, \"ticketIds\": [" + ticket1.getId() + ", " + ticket2.getId() + "] }"))
                .andExpect(status().isCreated());

        assertEquals(1, orderRepository.count());
    }
}
