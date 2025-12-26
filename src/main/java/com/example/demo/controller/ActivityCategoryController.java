@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // CREATE CATEGORY
    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(
            @Valid @RequestBody ActivityCategory category) {

        return ResponseEntity.ok(categoryService.save(category));
    }

    // GET CATEGORY BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategory(@PathVariable Long id) {

        ActivityCategory category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    // GET ALL CATEGORIES
    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
