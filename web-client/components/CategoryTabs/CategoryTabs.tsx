type Category = {
  id: string;
  title: string;
};

type CategoryTabsProps = {
  categories: Category[];
  activeCategory: string;
  onCategoryChange: (id: string) => void;
};

const CategoryTabs = ({
  categories,
  activeCategory,
  onCategoryChange,
}: CategoryTabsProps) => {
  return (
    <div className="flex overflow-x-auto gap-2 p-4 mt-4 mb-4 no-scrollbar">
      {categories.map((category) => (
        <button
          key={category.id}
          onClick={() => onCategoryChange(category.id)}
          className={`cursor-pointer px-4 py-2 rounded-full whitespace-nowrap text-sm font-medium transition-colors ${
            activeCategory === category.id
              ? "bg-primary text-white"
              : "bg-surface-variant text-gray-500"
          }`}
        >
          {category.title}
        </button>
      ))}
    </div>
  );
};

export default CategoryTabs;
