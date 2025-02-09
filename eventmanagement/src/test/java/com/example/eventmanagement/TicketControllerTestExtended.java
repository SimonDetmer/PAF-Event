@WebMvcTest(TicketController.class)
public class TicketControllerTestExtended {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Test
    public void testReserveTicket() throws Exception {
        Ticket ticket = new Ticket(new BigDecimal("50.00"), new AvailableState());

        Mockito.when(ticketService.reserveTicket(Mockito.anyLong())).thenReturn(ticket);

        mockMvc.perform(post("/tickets/1/reserve"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPurchaseTicket() throws Exception {
        Ticket ticket = new Ticket(new BigDecimal("50.00"), new ReservedState());

        Mockito.when(ticketService.purchaseTicket(Mockito.anyLong())).thenReturn(ticket);

        mockMvc.perform(post("/tickets/1/purchase"))
                .andExpect(status().isOk());
    }
}
