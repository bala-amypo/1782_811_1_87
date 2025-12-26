@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    // CREATE LOG
    @PostMapping
    public ResponseEntity<ActivityLog> createLog(
            @Valid @RequestBody ActivityLog log) {

        return ResponseEntity.ok(logService.save(log));
    }

    // GET ALL LOGS
    @GetMapping
    public ResponseEntity<List<ActivityLog>> getAll() {
        return ResponseEntity.ok(logService.getAll());
    }

    // GET LOG BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ActivityLog> getById(@PathVariable Long id) {

        return ResponseEntity.ok(logService.getById(id));
    }

    // GET LOGS BY USER
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(logService.getByUser(userId));
    }

    // GET LOGS BY ACTIVITY TYPE
    @GetMapping("/activity/{activityTypeId}")
    public ResponseEntity<List<ActivityLog>> getByActivity(
            @PathVariable Long activityTypeId) {

        return ResponseEntity.ok(logService.getByActivity(activityTypeId));
    }
}
