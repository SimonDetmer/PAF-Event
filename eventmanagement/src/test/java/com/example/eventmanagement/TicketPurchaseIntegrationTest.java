@SpringBootTest
@AutoConfigureMockMvc
public class TicketPurchaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    @Transactional
    public void testFullTicketPurchaseFlow() throws Exception {
        Ticket ticket = new Ticket(new BigDecimal("50.00"), new AvailableState());
        ticketRepository.save(ticket);

        mockMvc.perform(post("/tickets/" + ticket.getId() + "/reserve"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/tickets/" + ticket.getId() + "/purchase"))
                .andExpect(status().isOk());
    }
}
