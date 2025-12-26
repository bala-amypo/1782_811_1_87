@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    // CREATE ACTIVITY TYPE UNDER CATEGORY
    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ActivityType> createType(
            @PathVariable Long categoryId,
            @Valid @RequestBody ActivityType type) {

        ActivityType savedType = typeService.create(categoryId, type);
        return ResponseEntity.ok(savedType);
    }

    // GET TYPE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getType(@PathVariable Long id) {

        return ResponseEntity.ok(typeService.getById(id));
    }

    // GET TYPES BY CATEGORY
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getByCategory(
            @PathVariable Long categoryId) {

        return ResponseEntity.ok(typeService.getByCategory(categoryId));
    }
}
